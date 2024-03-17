-- INSERT INTO users (email, password, role, fullname, alamat, telepon)
-- VALUES 
--     ('john@example.com', 'password123', 'customer', 'John Doe', '123 Main St', '1234567890'),
--     ('jane@example.com', 'password456', 'customer', 'Jane Smith', '456 Oak St', '0987654321'),
--     ('admin@example.com', 'adminpass', 'admin', 'Admin User', '789 Elm St', '1122334455');


INSERT INTO product (product_name, deskripsi, harga, category_id, stok_quantity) 
VALUES 
('Nasi Goreng Spesial', 'Nasi goreng dengan campuran ayam, udang, dan telur.', 25000, 1, 50),
('Mie Ayam Bakso', 'Mie kuning dengan ayam panggang dan bakso dengan kuah kaldu.', 20000, 1, 40),
('Sate Ayam', 'Tusuk sate ayam yang dipanggang dengan bumbu kacang khas Indonesia.', 15000, 1, 30),
('Es Teh Manis', 'Teh manis dengan es batu.', 5000, 2, 60),
('Jus Jeruk Segar', 'Jus jeruk segar tanpa pemanis tambahan.', 10000, 2, 50),
('Es Krim Vanila', 'Es krim rasa vanila dengan potongan buah-buahan.', 12000, 3, 20),
('Soda Gembira', 'Minuman soda dengan campuran buah-buahan.', 15000, 3, 40),
('Pisang Goreng', 'Pisang goreng dengan taburan gula dan keju.', 8000, 3, 25);

INSERT INTO kategori (category_name)
VALUES
('Makanan'),
('Minuman'),
('Cemilan');
