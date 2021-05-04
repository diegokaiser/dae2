package com.isil.repository;

import com.isil.service.UsuarioService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.isil.model.Usuario;

import java.util.List;

@Repository
public class UsuarioRepository implements UsuarioService {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Usuario usuario) {
        final String SQL = "insert into usuario (nombre, apellido, correo, contrasena, tipoDocumento, numeroDocumento, idTipoUsuario, status, created_at, updated_at, deleted_at) values (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getContrasena(), usuario.getTipoDocumento(), usuario.getNumeroDocumento(), usuario.getIdTipoUsuario(), usuario.getStatus(), usuario.getCreated_at(), usuario.getUpdated_at(), usuario.getDeleted_at());
    }

    @Override
    public Usuario read(Integer id) {
        final String SQL = "select * from usuario where id = ?";
        return jdbcTemplate.queryForObject(SQL, getUsuarioRowMapper(), id);
    }

    private RowMapper<Usuario> getUsuarioRowMapper() {
        return (r, i) -> {
            int idUsuario          = r.getInt("idUsuario");
            String nombre          = r.getString("nombre");
            String apellido        = r.getString("apellido");
            String correo          = r.getString("correo");
            String contrasena      = r.getString("contrasena");
            Integer tipoDocumento  = r.getInt("tipoDocumento");
            String numeroDocumento = r.getString("numeroDocumento");
            Integer idTipoUsuario  = r.getInt("idTipoUsuario");
            Integer status         = r.getInt("status");
            String created_at      = r.getString("created_at");
            String updated_at      = r.getString("updated_at");
            String deleted_at      = r.getString("deleted_at");
            return new Usuario(idUsuario, nombre, apellido, correo, contrasena, tipoDocumento, numeroDocumento, idTipoUsuario, status, created_at, updated_at, deleted_at);
        };
    }

    @Override
    public void update(Usuario usuario) {
        final String SQL = "update usuario set nombre = ?";
        jdbcTemplate.update(SQL, usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getContrasena(), usuario.getIdTipoUsuario(), usuario.getNumeroDocumento(), usuario.getIdTipoUsuario(), usuario.getStatus());
    }

    @Override
    public void delete(Integer id) {
        final String SQL = "delete usuario where id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public List<Usuario> all() {
        final String SQL = "select * from usuario";
        return jdbcTemplate.query(SQL, getUsuarioRowMapper());
    }

    @Override
    public List<Usuario> usersActivated() {
        final String SQL ="select * from usuario where status=1";
        return jdbcTemplate.query(SQL, getUsuarioRowMapper());
    }

    @Override
    public List<Usuario> usersInactivated() {
        final String SQL ="select * from usuario where status=0";
        return jdbcTemplate.query(SQL, getUsuarioRowMapper());
    }

    @Override
    public List<Usuario> usersAdministrators() {
        final String SQL ="select * from usuario where idTipoUsuario=1 and idTipoUsuario=2";
        return jdbcTemplate.query(SQL, getUsuarioRowMapper());
    }
}
