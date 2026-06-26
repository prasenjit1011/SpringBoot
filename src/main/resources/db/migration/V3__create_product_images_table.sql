CREATE TABLE product_images (
    id BIGSERIAL PRIMARY KEY,
    file_name VARCHAR(255),
    image_url VARCHAR(500),

    product_id BIGINT NOT NULL,

    CONSTRAINT fk_product_image_product
        FOREIGN KEY (product_id)
        REFERENCES products(id)
        ON DELETE CASCADE
);