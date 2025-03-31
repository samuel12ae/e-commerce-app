INSERT INTO category (id, description, name) VALUES
    (nextval('category_seq'), 'Electronics and gadgets', 'Electronics'),
    (nextval('category_seq'), 'Household furniture', 'Furniture'),
    (nextval('category_seq'), 'Various clothing items', 'Clothing'),
    (nextval('category_seq'), 'Food and beverages', 'Groceries');

INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES
    (nextval('product_seq'), 'Smartphone with 128GB storage', 'Smartphone', 50, 699.99, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), '4K Ultra HD Smart TV', 'Smart TV', 20, 1199.99, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Comfortable leather sofa', 'Leather Sofa', 10, 899.99, (SELECT id FROM category WHERE name = 'Furniture')),
    (nextval('product_seq'), 'Wooden dining table with 6 chairs', 'Dining Table Set', 5, 1299.99, (SELECT id FROM category WHERE name = 'Furniture')),
    (nextval('product_seq'), 'Cotton T-shirt in various sizes', 'T-shirt', 100, 19.99, (SELECT id FROM category WHERE name = 'Clothing')),
    (nextval('product_seq'), 'Pack of organic apples (1kg)', 'Organic Apples', 200, 4.99, (SELECT id FROM category WHERE name = 'Groceries')),
    (nextval('product_seq'), 'Fresh milk (1L)', 'Milk', 150, 2.49, (SELECT id FROM category WHERE name = 'Groceries'));