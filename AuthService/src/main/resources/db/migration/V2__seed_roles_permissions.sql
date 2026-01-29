INSERT INTO permissions(code, name) VALUES
('VIEW', 'Ver'),
('CREATE', 'Crear'),
('APPROVE', 'Aprobar'),
('AUDIT', 'Auditar')
ON CONFLICT (code) DO NOTHING;

INSERT INTO roles(code, name) VALUES
('ADMIN', 'Administrador'),
('CONSEJO', 'Consejo'),
('PORTERIA', 'Portería'),
('RESIDENTE', 'Residente'),
('ARRENDATARIO', 'Arrendatario'),
('PROVEEDOR', 'Proveedor')
ON CONFLICT (code) DO NOTHING;

-- ADMIN -> todos
INSERT INTO role_permissions(role_id, permission_id)
SELECT r.id, p.id
FROM roles r CROSS JOIN permissions p
WHERE r.code='ADMIN'
ON CONFLICT DO NOTHING;

-- CONSEJO -> VIEW, APPROVE, AUDIT
INSERT INTO role_permissions(role_id, permission_id)
SELECT r.id, p.id
FROM roles r JOIN permissions p ON p.code IN ('VIEW','APPROVE','AUDIT')
WHERE r.code='CONSEJO'
ON CONFLICT DO NOTHING;

-- PORTERIA -> VIEW, CREATE
INSERT INTO role_permissions(role_id, permission_id)
SELECT r.id, p.id
FROM roles r JOIN permissions p ON p.code IN ('VIEW','CREATE')
WHERE r.code='PORTERIA'
ON CONFLICT DO NOTHING;

-- RESIDENTE -> VIEW
INSERT INTO role_permissions(role_id, permission_id)
SELECT r.id, p.id
FROM roles r JOIN permissions p ON p.code IN ('VIEW')
WHERE r.code='RESIDENTE'
ON CONFLICT DO NOTHING;

-- ARRENDATARIO -> VIEW
INSERT INTO role_permissions(role_id, permission_id)
SELECT r.id, p.id
FROM roles r JOIN permissions p ON p.code IN ('VIEW')
WHERE r.code='ARRENDATARIO'
ON CONFLICT DO NOTHING;

-- PROVEEDOR -> VIEW (si luego quieres CREATE también lo agregas)
INSERT INTO role_permissions(role_id, permission_id)
SELECT r.id, p.id
FROM roles r JOIN permissions p ON p.code IN ('VIEW')
WHERE r.code='PROVEEDOR'
ON CONFLICT DO NOTHING;
