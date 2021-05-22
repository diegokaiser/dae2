/*
create table usuario (
    idUsuario identity primary key,
    nombre varchar(40) not null,
    apellido varchar(40) not null,
    correo varchar(60) not null,
    contrasena(30) varchar not null,
    tipoDocumento varchar not null,
    numeroDocumento(15) int not null,
    idTipoUsuario int not null,
    status int default '0',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)

create table cine (
    idCine identity primary key,
    nombre varchar(50) not null,
    direccion varchar(50) not null,
    logo varchar not null,
    idDistrito int not null,
    status int default '1',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)

create table compra (
    idCompra identity primary key,
    numeroEntradas int not null,
    total double not null,
    idUsuario int not null,
    idEntrada int not null,
    status int default '0',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)

create table distrito (
    idDistrito identity primary key,
    nombre varchar(40) not null,
    status int default '1',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)

create table entrada (
    idEntrada identity primary key,
    precio double not null,
    tipo varchar(10) not null,
    stock int not null,
    idSala int not null,
    idPelicula int not null,
    status int default '1',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)

create table pelicula (
    idPelicula identity primary key,
    nombre varchar(50) not null,
    duracion varchar(15) not null,
    fechaEstreno date not null,
    idioma varchar(30) not null,
    pais varchar(30) not null,
    subtitulos bit null,
    portada varchar(30) not null,
    descripcion varchar(300) not null,
    genero varchar(30) not null,
    destacado bit default '0',
    status int default '0',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)

create table sala (
    idSala identity primary key,
    numero smallint not null,
    capacidad smallint not null,
    tipoSala varchar(10) not null,
    idCine int not null,
    status int default '1',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)

create table tipousuario (
    idTipoUsuario identity primary key,
    nombre varchar(20) not null,
    descripcion varchar(40) not null,
    status int default '1',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)

create table usuarioentrada (
    idUsuarioEntrada identity not null,
    idCompra int not null,
    status int default '1',
    created_at current_date,
    updated_at current_date,
    deleted_at current_date,
)














*/