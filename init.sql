CREATE TABLE "Venta"(
 "idVenta" SERIAL NOT NULL,
 "idClienteFK" INTEGER NOT NULL,
 "fechaVenta" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
 "total" BIGINT NOT NULL
);
ALTER TABLE
 "Venta" ADD PRIMARY KEY("idVenta");
CREATE TABLE "Usuario"(
 "idUsuario" SERIAL NOT NULL,
 "idRolFK" INTEGER NOT NULL,
 "idCiudadFK" INTEGER NOT NULL,









"nombre" VARCHAR(32) NOT NULL,
 "apellido" VARCHAR(32) NOT NULL,
 "username" VARCHAR(255) NOT NULL,
 "password" VARCHAR(255) NOT NULL,
 "email" VARCHAR(255) NOT NULL,
 "fechaRegistro" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
 "telefono" VARCHAR(10) NOT NULL
);
ALTER TABLE
 "Usuario" ADD PRIMARY KEY("idUsuario");
ALTER TABLE
 "Usuario" ADD CONSTRAINT "usuario_username_unique" UNIQUE("username");
ALTER TABLE
 "Usuario" ADD CONSTRAINT "usuario_email_unique" UNIQUE("email");
CREATE TABLE "Ciudad"(
 "idCiudad" SERIAL NOT NULL,
 "idDepartamentoFK" INTEGER NOT NULL,
 "nombre" VARCHAR(32) NOT NULL
);
ALTER TABLE
 "Ciudad" ADD PRIMARY KEY("idCiudad");
CREATE TABLE "Departamento"(
 "idDepartamento" SERIAL NOT NULL,
 "nombre" VARCHAR(32) NOT NULL
);
ALTER TABLE
 "Departamento" ADD PRIMARY KEY("idDepartamento");
CREATE TABLE "Producto"(
 "idProducto" SERIAL NOT NULL,
 "nombre" VARCHAR(32) NOT NULL,
 "precio" DECIMAL(8, 2) NOT NULL,
 "descripcion" VARCHAR(255) NOT NULL,
 "fechaCreacion" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
 "fechaActualizacion" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
 "Producto" ADD PRIMARY KEY("idProducto");
CREATE TABLE "Categoria"(






 "idCategoria" SERIAL NOT NULL,
 "nombre" VARCHAR(255) NOT NULL
);
ALTER TABLE
 "Categoria" ADD PRIMARY KEY("idCategoria");
CREATE TABLE "venta_producto"(
 "id" SERIAL NOT NULL,
 "idVenta" INTEGER NOT NULL,
 "idProducto" INTEGER NOT NULL,
 "cantidad" BIGINT NOT NULL
);
ALTER TABLE
 "venta_producto" ADD PRIMARY KEY("id");
CREATE INDEX "venta_producto_idventa_index" ON
 "venta_producto"("idVenta");
CREATE INDEX "venta_producto_idproducto_index" ON
 "venta_producto"("idProducto");
CREATE TABLE "RolUsuario"(
 "idRol" SERIAL NOT NULL,
 "rol" VARCHAR(255) NOT NULL
);
ALTER TABLE
 "RolUsuario" ADD PRIMARY KEY("idRol");
ALTER TABLE
 "RolUsuario" ADD CONSTRAINT "rolusuario_rol_unique" UNIQUE("rol");
CREATE TABLE "ProductoCategoria"(
 "id" SERIAL NOT NULL,
 "idProducto" INTEGER NOT NULL,
 "idCategoria" INTEGER NOT NULL
);
ALTER TABLE
 "ProductoCategoria" ADD PRIMARY KEY("id");
CREATE INDEX "productocategoria_idproducto_index" ON
 "ProductoCategoria"("idProducto");
CREATE INDEX "productocategoria_idcategoria_index" ON
 "ProductoCategoria"("idCategoria");
CREATE TABLE "Almacen"(
 "idAlmacen" SERIAL NOT NULL,





 "nombre" VARCHAR(255) NOT NULL,
 "idCiudadFK" INTEGER NOT NULL
);
ALTER TABLE
 "Almacen" ADD PRIMARY KEY("idAlmacen");
CREATE TABLE "AlmacenProducto"(
 "id" SERIAL NOT NULL,
 "idAlmacenFK" INTEGER NOT NULL,
 "idProductoFK" INTEGER NOT NULL,
 "stock" BIGINT NOT NULL,
 "direccion" VARCHAR(255) NOT NULL
);
ALTER TABLE
 "AlmacenProducto" ADD PRIMARY KEY("id");
ALTER TABLE
 "Usuario" ADD CONSTRAINT "usuario_idciudadfk_foreign" FOREIGN
KEY("idCiudadFK") REFERENCES "Ciudad"("idCiudad");
ALTER TABLE
 "venta_producto" ADD CONSTRAINT "venta_producto_idproducto_foreign"
FOREIGN KEY("idProducto") REFERENCES "Producto"("idProducto");
ALTER TABLE
 "Usuario" ADD CONSTRAINT "usuario_idrolfk_foreign" FOREIGN
KEY("idRolFK") REFERENCES "RolUsuario"("idRol");
ALTER TABLE
 "AlmacenProducto" ADD CONSTRAINT "almacenproducto_idalmacenfk_foreign"
FOREIGN KEY("idAlmacenFK") REFERENCES "Almacen"("idAlmacen");
ALTER TABLE
 "venta_producto" ADD CONSTRAINT "venta_producto_idventa_foreign"
FOREIGN KEY("idVenta") REFERENCES "Venta"("idVenta");
ALTER TABLE
 "ProductoCategoria" ADD CONSTRAINT
"productocategoria_idcategoria_foreign" FOREIGN KEY("idCategoria")
REFERENCES "Categoria"("idCategoria");
ALTER TABLE
 "Venta" ADD CONSTRAINT "venta_idclientefk_foreign" FOREIGN
KEY("idClienteFK") REFERENCES "Usuario"("idUsuario");
ALTER TABLE



"Almacen" ADD CONSTRAINT "almacen_idciudadfk_foreign" FOREIGN
KEY("idCiudadFK") REFERENCES "Ciudad"("idCiudad");
ALTER TABLE
 "Ciudad" ADD CONSTRAINT "ciudad_iddepartamentofk_foreign" FOREIGN
KEY("idDepartamentoFK") REFERENCES "Departamento"("idDepartamento");
ALTER TABLE
 "ProductoCategoria" ADD CONSTRAINT
"productocategoria_idproducto_foreign" FOREIGN KEY("idProducto")
REFERENCES "Producto"("idProducto");
ALTER TABLE
 "AlmacenProducto" ADD CONSTRAINT "almacenproducto_idproductofk_foreign"
FOREIGN KEY("idProductoFK") REFERENCES "Producto"("idProducto");
-- Datos de dominio
-- 1. Insertar Departamentos
INSERT INTO "Departamento" ("nombre") VALUES
('Cundinamarca'),
('Antioquia'),
('Valle del Cauca'),
('Santander'),
('Atlantico');
-- 2. Insertar Ciudades
-- Bogotá para Cundinamarca (idDepartamento = 1)
INSERT INTO "Ciudad" ("idDepartamentoFK", "nombre") VALUES
((SELECT "idDepartamento" FROM "Departamento" WHERE "nombre" =
'Cundinamarca'), 'Bogotá D.C.'),
((SELECT "idDepartamento" FROM "Departamento" WHERE "nombre" =
'Cundinamarca'), 'Soacha');
-- Medellín para Antioquia (idDepartamento = 2)
INSERT INTO "Ciudad" ("idDepartamentoFK", "nombre") VALUES
((SELECT "idDepartamento" FROM "Departamento" WHERE "nombre" =
'Antioquia'), 'Medellín'),
((SELECT "idDepartamento" FROM "Departamento" WHERE "nombre" =
'Antioquia'), 'Envigado');


Cali para Valle del Cauca (idDepartamento = 3)
INSERT INTO "Ciudad" ("idDepartamentoFK", "nombre") VALUES
((SELECT "idDepartamento" FROM "Departamento" WHERE "nombre" = 'Valle del
Cauca'), 'Cali'),
((SELECT "idDepartamento" FROM "Departamento" WHERE "nombre" = 'Valle del
Cauca'), 'Palmira');
-- Bucaramanga para Santander (idDepartamento = 4)
INSERT INTO "Ciudad" ("idDepartamentoFK", "nombre") VALUES
((SELECT "idDepartamento" FROM "Departamento" WHERE "nombre" =
'Santander'), 'Bucaramanga');
-- Barranquilla para Atlantico (idDepartamento = 5)
INSERT INTO "Ciudad" ("idDepartamentoFK", "nombre") VALUES
((SELECT "idDepartamento" FROM "Departamento" WHERE "nombre" =
'Atlantico'), 'Barranquilla');
-- 3. Insertar Categorías de Productos
INSERT INTO "Categoria" ("nombre") VALUES
('Electrónica'),
('Ropa'),
('Alimentos'),
('Hogar'),
('Libros'),
('Deportes');
-- 4. Insertar Roles de Usuario
INSERT INTO "RolUsuario" ("rol") VALUES
('ADMIN'),
('CLIENTE'),
('EMPLEADO');
