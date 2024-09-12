package io.zhc1.realworld.core.model;


public interface OrderRepository extends JpaRepository<Order, Long> {
    // Eventuelle spesialspørringer for Order kan legges til her
}
