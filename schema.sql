DROP TABLE IF EXISTS "user_type" CASCADE;
DROP TABLE IF EXISTS "users" CASCADE;
DROP TABLE IF EXISTS "invoice" CASCADE;
DROP TABLE IF EXISTS "discount" CASCADE;
DROP TABLE IF EXISTS "discount_type" CASCADE;
DROP TABLE IF EXISTS "product" CASCADE;
DROP TABLE IF EXISTS "category" CASCADE;
DROP TABLE IF EXISTS "invoice_product" CASCADE;

CREATE TABLE "users" (
  "id" SERIAL PRIMARY KEY,
  "user_type_id" int,
  "lastname" varchar,
  "name" varchar,
  "document_type" varchar,
  "document" varchar,
  "is_affiliated" boolean,
  "created_at" timestamp default CURRENT_TIMESTAMP,
  "updated_at" timestamp default CURRENT_TIMESTAMP
);

CREATE TABLE "user_type" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar,
  "created_at" timestamp default CURRENT_TIMESTAMP,
  "updated_at" timestamp default CURRENT_TIMESTAMP
);

CREATE TABLE "invoice" (
  "id" SERIAL PRIMARY KEY,
  "client_id" int,
  "amount" decimal,
  "currency" varchar,
  "created_at" timestamp default CURRENT_TIMESTAMP,
  "updated_at" timestamp default CURRENT_TIMESTAMP
);

CREATE TABLE "discount" (
  "id" SERIAL PRIMARY KEY,
  "code" varchar,
  "amount" decimal,
  "created_at" timestamp default CURRENT_TIMESTAMP,
  "updated_at" timestamp default CURRENT_TIMESTAMP
);

CREATE TABLE "product" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar,
  "price" decimal,
  "currency" varchar,
  "category_id" int,
  "created_at" timestamp default CURRENT_TIMESTAMP,
  "updated_at" timestamp default CURRENT_TIMESTAMP
);

CREATE TABLE "category" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar,
  "created_at" timestamp default CURRENT_TIMESTAMP,
  "updated_at" timestamp default CURRENT_TIMESTAMP
);

CREATE TABLE "invoice_product" (
  "invoice_id" int,
  "product_id" int,
  "quantity" int,
  "created_at" timestamp default CURRENT_TIMESTAMP,
  "updated_at" timestamp default CURRENT_TIMESTAMP,
  PRIMARY KEY ("invoice_id", "product_id")
);

ALTER TABLE "users" ADD FOREIGN KEY ("user_type_id") REFERENCES "user_type" ("id");

ALTER TABLE "invoice" ADD FOREIGN KEY ("client_id") REFERENCES "users" ("id");

ALTER TABLE "product" ADD FOREIGN KEY ("category_id") REFERENCES "category" ("id");

ALTER TABLE "invoice_product" ADD FOREIGN KEY ("invoice_id") REFERENCES "invoice" ("id");

ALTER TABLE "invoice_product" ADD FOREIGN KEY ("product_id") REFERENCES "product" ("id");

