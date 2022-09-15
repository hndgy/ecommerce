package fr.hndgy.ecommerce.model;

public enum OrderStatus {
    PENDING,
    AWAITING_PAYMENT,
    PAYMENT_FULLFILLED,
    AWAITING_SHIPMENT,
    COMPLETED,
    CANCELLED,
    DECLINED,
    REFUNDED
}
