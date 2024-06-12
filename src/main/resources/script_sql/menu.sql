CREATE TABLE menu(
    id   Int NOT NULL primary key ,
    name Varchar (50) NOT NULL,
    id_price int references price(id),
    id_restaurant int references restaurant(id)
);


insert into menu (id, name, id_price, id_restaurant) VALUES
                 (1, 'Hot Dog', 1, 1),
                 (2, 'Burger', 2, 1);


