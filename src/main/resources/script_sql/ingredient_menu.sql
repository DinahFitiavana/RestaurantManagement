CREATE TABLE ingredient_menu(
    id            Int NOT NULL primary key ,
    quantity      float NOT NULL ,
    id_menu       Int NOT NULL REFERENCES menu(id),
    id_ingredient Int NOT NULL REFERENCES ingredient(id)
);

insert into ingredient_menu (id, quantity, id_menu, id_ingredient) VALUES
                            (1, 1, 1, 4),
                            (2, 1, 1, 2),
                            (3, 0.005, 1, 1),
                            (4, 0.005, 1, 3),
                            (5, 1, 2, 2),
                            (6, 0.25, 2, 5),
                            (7, 0.005, 2, 3);