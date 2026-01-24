**1) Identidad, roles y permisos (core)**



Usuarios: administrador, consejo, portería, residentes, arrendatarios, proveedores



Roles por torre/bloque y por unidad



Permisos granulares (ver, aprobar, crear, auditar)



**2) Unidades y residentes**



Torres/bloques, apartamentos/casas, parqueaderos, depósitos



Propietario vs residente vs arrendatario



Grupo familiar, mascotas (si aplica)



Estado de ocupación e historial



**3) Cuotas de administración y cartera (muy clave)**



Conceptos: administración, multas, intereses, cuotas extra, fondo



Liquidación mensual automática



Cartera por unidad, acuerdos de pago, intereses, paz y salvo



Cargue masivo, notas crédito/débito



**4) Pagos e integración financiera**



Registro de pagos (manual y automático)



Integración con pasarela (Wompi/PayU/PlacetoPay) o banco



Conciliación bancaria



Facturas/recibos y soporte contable básico



**5) Portería y control de acceso**



Registro de visitantes (QR / PIN)



Autorizaciones por el residente



Historial de ingresos/salidas



Vehículos, domiciliarios, proveedores



Control de correspondencia/paquetería



**6) PQRS / Mesa de ayuda**



Tickets por categorías (mantenimiento, ruido, seguridad, aseo)



SLA, asignación, estados, comentarios, adjuntos



Encuesta de satisfacción



**7) Mantenimiento y activos**



Inventario de activos (bombas, puertas, cámaras)



Plan de mantenimiento preventivo



Órdenes de trabajo, proveedores, costos



Bitácoras y evidencias



**8) Reservas de zonas comunes**



Calendario, cupos, reglas (horarios, aforo, anticipo)



Cobros por uso (si aplica)



Penalizaciones por no asistencia o daños



**9) Comunicaciones y notificaciones**



Comunicados, asambleas, actas, encuestas



Notificaciones por email/SMS/WhatsApp (si legal/viable) y push en app



Plantillas de mensajes y trazabilidad



**10) Documentos y legal**



Reglamento, manual convivencia, actas, contratos proveedores



Versionado y control de acceso



Firma electrónica (opcional)



**11) Reportes y analítica**



Cartera por edad, recaudo, morosidad



Ingresos/gastos (si llevas contabilidad en el sistema)



Estadísticas de acceso, PQRS, reservas



**12) Auditoría y cumplimiento**



Log de acciones (quién cambió qué y cuándo)



Evidencia de aprobaciones



Retención de datos y backups



## **(mapa de microservicios por dominio)**



Identity/Auth Service (OAuth2/OIDC, roles)



Resident/Unit Service (unidades, residentes, parqueaderos)



Billing \& Ledger Service (liquidación, conceptos, cartera)



Payments Service (pasarela, conciliación, webhooks)



Access Control Service (visitas, QR, portería)



Work Orders Service (mantenimiento, activos, proveedores)



Reservations Service (zonas comunes)



PQRS Service (tickets)



Notifications Service (email/SMS/push)



Documents Service (archivos, permisos, versionado)



Reporting Service (ETL/consultas, BI)

