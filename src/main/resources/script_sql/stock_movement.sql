CREATE TABLE stock_movement (
    id int primary key,
    type varchar(50),
    quantity decimal,
    date timestamp,
    id_ingredient int references ingredient(id)
);

insert into stock_movement (id, type, quantity, "date", id_ingredient) VALUES
                           (1, 'sortie', 1, '2024-06-02 09:25', 2),
                           (2, 'sortie', 1, '2024-06-02 09:26', 4),
                           (3, 'sortie', 0.005, '2024-06-02 09:27', 1),
                           (4, 'sortie', 0.005, '2024-06-02 09:28', 3);
