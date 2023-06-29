-- DROP SCHEMA learnflow;

CREATE SCHEMA learnflow AUTHORIZATION mokidkuu;

-- DROP SEQUENCE learnflow.conteudo_id_seq;

CREATE SEQUENCE learnflow.conteudo_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE learnflow.tema_id_seq;

CREATE SEQUENCE learnflow.tema_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE learnflow.usuario_id_seq;

CREATE SEQUENCE learnflow.usuario_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- learnflow.usuario definition

-- Drop table

-- DROP TABLE learnflow.usuario;

CREATE TABLE learnflow.usuario (
	id serial4 NOT NULL,
	nome varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	senha varchar(100) NOT NULL,
	data_criacao timestamp NOT NULL DEFAULT now(),
	CONSTRAINT usuario_email_key UNIQUE (email),
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);


-- learnflow.tema definition

-- Drop table

-- DROP TABLE learnflow.tema;

CREATE TABLE learnflow.tema (
	id serial4 NOT NULL,
	nome varchar(100) NOT NULL,
	descricao text NOT NULL,
	data_criacao timestamp NOT NULL DEFAULT now(),
	tema_dependente_id int4 NULL,
	usuario_id int4 NULL,
	CONSTRAINT tema_pkey PRIMARY KEY (id),
	CONSTRAINT fk_tema_tema_dependente FOREIGN KEY (tema_dependente_id) REFERENCES learnflow.tema(id) ON DELETE CASCADE,
	CONSTRAINT tema_fk FOREIGN KEY (usuario_id) REFERENCES learnflow.usuario(id) ON DELETE CASCADE
);


-- learnflow.arquivos definition

-- Drop table

-- DROP TABLE learnflow.arquivos;

CREATE TABLE learnflow.arquivos (
	id int4 NOT NULL DEFAULT nextval('learnflow.conteudo_id_seq'::regclass),
	tema_id int4 NOT NULL,
	data_criacao timestamp NOT NULL DEFAULT now(),
	nome varchar NOT NULL,
	link varchar NOT NULL,
	usuario_id int4 NULL,
	CONSTRAINT conteudo_pkey PRIMARY KEY (id),
	CONSTRAINT arquivos_usuario_fk FOREIGN KEY (usuario_id) REFERENCES learnflow.usuario(id),
	CONSTRAINT conteudo_tema_id_fkey FOREIGN KEY (tema_id) REFERENCES learnflow.tema(id) ON DELETE CASCADE
);


-- learnflow.favoritos definition

-- Drop table

-- DROP TABLE learnflow.favoritos;

CREATE TABLE learnflow.favoritos (
	tema_id int4 NOT NULL,
	usuario_id int4 NOT NULL,
	data_criacao timestamp NOT NULL DEFAULT now(),
	CONSTRAINT tema_usuario_pkey PRIMARY KEY (tema_id, usuario_id),
	CONSTRAINT tema_usuario_tema_id_fkey FOREIGN KEY (tema_id) REFERENCES learnflow.tema(id) ON DELETE CASCADE,
	CONSTRAINT tema_usuario_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES learnflow.usuario(id)
);
