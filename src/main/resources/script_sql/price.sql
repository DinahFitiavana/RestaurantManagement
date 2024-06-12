CREATE TABLE price (
    id int primary key ,
    date DATE,
    total_price float,
    selling_price float
);

insert into price (id, "date", total_price, selling_price) VALUES
                  (1, '2024-06-01', 3750, 5000),
                  (2, '2024-06-01', 4200, 6000);