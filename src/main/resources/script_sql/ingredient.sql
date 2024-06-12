CREATE TABLE ingredient(
    id      Int         NOT NULL primary key,
    name    Varchar(50) NOT NULL,
    price float NOT NULL,
    id_unit Int NOT NULL REFERENCES unit (id)
);

insert into ingredient (id, name, price, id_unit) VALUES
                       (1, 'ketchup', 5000, 2),
                       (2, 'pain', 500, 3),
                       (3, 'mayonnaise', 10000, 2),
                       (4, 'saucisse', 20000, 1),
                       (5, 'poulet', 25000, 1);
