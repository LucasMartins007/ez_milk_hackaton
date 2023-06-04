INSERT INTO public.pessoa
(id, nome, id_propriedade, id_tecnico)
VALUES(1, 'Mellow musk', 1, 1);

INSERT INTO public.propriedade
(id, latitude, longitude, nome, status_propriedade, id_rebanho)
VALUES(1, 123456789, 98765431, 'prorpiedade sul', 'REGISTRO_OK', 1);


INSERT INTO public.rebanho
(id, lactacao, quantidade_total, seca)
VALUES(1, 30, 80, 50);

INSERT INTO public.tecnico
(id, nome)
VALUES(1, 'Lucas');


INSERT INTO public.tipo_registro
(id, descricao, is_entrada)
VALUES(2, 'VOLUMOSO',  false);
INSERT INTO public.tipo_registro
(id, descricao, is_entrada)
VALUES(3, 'MEDICAMENTOS', false);
INSERT INTO public.tipo_registro
(id, descricao, is_entrada)
VALUES(4, 'MAO_DE_OBRA', false);
INSERT INTO public.tipo_registro
(id, descricao, is_entrada)
VALUES(5, 'MINERAL', false);
INSERT INTO public.tipo_registro
(id, descricao, is_entrada)
VALUES(1, 'CONCENTRADOS', false);
INSERT INTO public.tipo_registro
(id, descricao, is_entrada)
VALUES(6, 'VENDA_LEITE', true);

INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(2, 'SOJA', 1);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(3, 'ALGODAO', 1);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(4, 'MANDIOCA', 1);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(5, 'SORGO', 1);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(6, 'RACAO', 1);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(7, 'TRIGO', 1);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(8, 'BRACHIARIA', 2);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(9, 'CAPIAÇU', 2);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(10, 'CUPIM-ELEFANTE', 2);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(11, 'TIFTON', 2);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(12, 'SILAGEM', 2);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(13, 'CAPIM-TANZANIA', 2);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(14, 'CALCIO', 5);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(15, 'FOSFORO', 5);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(16, 'SAL MINERAL', 5);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(17, 'SAL COMUM', 5);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(18, 'SAL PROTEINADO', 5);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(19, 'ALUGUEL DE MAQUINAS', 4);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(20, 'INSUMOS', 4);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(21, 'COMBUSTIVEL', 4);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(22, 'LIMPEZA', 4);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(23, 'VETERINARIO', 4);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(24, 'CERCAS', 4);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(25, 'ANTIBIOTICOS', 3);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(26, 'VACINAS', 3);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(27, 'HOMEOPLASTICOS', 3);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(28, 'VERMIFUGO', 3);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(29, 'ANTI-INFLAMATORIO', 3);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(30, 'ANALGESICO', 3);
INSERT INTO public.tipo_registro_filho
(id, descricao, id_tipo_registro)
VALUES(1, 'MILHO', 1);
