DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;

CREATE TABLE products (
  id    SERIAL PRIMARY KEY,
  name  VARCHAR(100) NOT NULL,
  price INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
  id       SERIAL PRIMARY KEY,
  name     VARCHAR(100) NOT NULL,
  email    VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);
CREATE TABLE orders (
  id         SERIAL PRIMARY KEY,
  user_id    INT         NOT NULL REFERENCES users(id),
  created_at TIMESTAMP   NOT NULL DEFAULT NOW()
);

CREATE TABLE order_items (
  id         SERIAL PRIMARY KEY,
  order_id   INT NOT NULL REFERENCES orders(id),
  product_id INT NOT NULL,
  name       VARCHAR(100) NOT NULL,
  price      INT NOT NULL,
  quantity   INT NOT NULL
);