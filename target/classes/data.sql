INSERT INTO Autor (id, nome) VALUES(1, 'Rafael F');
INSERT INTO Autor (id, nome) VALUES(2, 'Fernando R');

INSERT INTO Livro (id, titulo, foto, quantidade, autor_id_id) VALUES(1, 'O Livro do Titulo', null, 1, 1);
INSERT INTO Livro (id, titulo, foto, quantidade, autor_id_id) VALUES(2, 'Titulo do Livro', null, 1, 2);

INSERT INTO Usuario (id, username, email, password) VALUES(1, 'user', 'user@user.com', '123456');

INSERT INTO Review (id, avaliacao, comentario, livro_id, usuario_id) VALUES(1, 10, 'O melhor livro', 1, 1);
INSERT INTO Review (id, avaliacao, comentario, livro_id, usuario_id) VALUES(2, 8, 'Poucas informações importantes', 2, 1);

INSERT INTO Emprestimo (id, data_emprestimo, data_devolucao, livro_id, usuario_id) VALUES(1, '2018-01-01', '2018-01-02', 1, 1);
INSERT INTO Emprestimo (id, data_emprestimo, data_devolucao, livro_id, usuario_id) VALUES(2, '2018-01-01', '2018-01-02', 2, 1);