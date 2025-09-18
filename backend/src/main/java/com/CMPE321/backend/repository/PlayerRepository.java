package com.CMPE321.backend.repository;

import com.CMPE321.backend.Player;
import com.CMPE321.backend.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PlayerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Player> playerRowMapper = new RowMapper<Player>() {
        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setUsername(rs.getString("username"));
            player.setName(rs.getString("name"));
            player.setSurname(rs.getString("surname"));
            player.setNationality(rs.getString("nationality"));
            player.setDateOfBirth(rs.getDate("date_of_birth") != null ?
                rs.getDate("date_of_birth").toLocalDate() : null);
            player.setFideId(rs.getString("fide_id"));
            player.setEloRating(rs.getInt("elo_rating"));
            player.setTitleId(rs.getObject("title_id", Integer.class));
            player.setTitleName(rs.getString("title_name"));
            return player;
        }
    };

    private final RowMapper<Match> matchRowMapper = new RowMapper<Match>() {
        @Override
        public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
            Match match = new Match();
            match.setMatchId(rs.getInt("match_id"));
            match.setHallId(rs.getInt("hall_id"));
            match.setTableId(rs.getInt("table_id"));
            match.setWhitePlayerTeam(rs.getInt("white_player_team"));
            match.setWhitePlayer(rs.getString("white_player"));
            match.setBlackPlayerTeam(rs.getInt("black_player_team"));
            match.setBlackPlayer(rs.getString("black_player"));
            match.setResult(rs.getString("result"));
            match.setTimeSlot(rs.getObject("time_slot", Integer.class));
            match.setDate(rs.getDate("date") != null ? rs.getDate("date").toLocalDate() : null);
            match.setAssignedArbiterUsername(rs.getString("assigned_arbiter_username"));
            match.setRating(rs.getObject("rating", Integer.class));
            match.setCreatorCoachUsername(rs.getString("creator_coach_username"));
            return match;
        }
    };

    public Player findByUsername(String username) {
        String sql = "SELECT p.*, u.name, u.surname, u.nationality, t.title_name " +
                     "FROM Player p " +
                     "JOIN User u ON p.username = u.username " +
                     "LEFT JOIN Title t ON p.title_id = t.title_id " +
                     "WHERE p.username = ?";

        List<Player> players = jdbcTemplate.query(sql, playerRowMapper, username);
        return players.isEmpty() ? null : players.get(0);
    }

    public List<Match> findMatchesByPlayer(String username) {
        String sql = "SELECT * FROM `Match` " +
                     "WHERE white_player = ? OR black_player = ? " +
                     "ORDER BY date DESC, time_slot DESC";

        return jdbcTemplate.query(sql, matchRowMapper, username, username);
    }

    public List<Player> findAllPlayers() {
        String sql = "SELECT p.*, u.name, u.surname, u.nationality, t.title_name " +
                     "FROM Player p " +
                     "JOIN User u ON p.username = u.username " +
                     "LEFT JOIN Title t ON p.title_id = t.title_id " +
                     "ORDER BY p.elo_rating DESC";

        return jdbcTemplate.query(sql, playerRowMapper);
    }
}