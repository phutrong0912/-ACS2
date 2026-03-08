package com.dacs2.repository;

import com.dacs2.model.Orders;
import com.dacs2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByUserIdAndProcessed(int userId, boolean processed);

//    public Page<Orders> findByOrderIdContainingIgnoreCase(Pageable pageable, String orderId);

    Page<Orders> findByOrderIdContainingIgnoreCaseAndProcessed(String orderId, Boolean processed, Pageable pageable);

    Orders findByOrderId(String orderId);

//    public Orders findByOrderIdAndProcessed(String orderId, Boolean processed);

    @Query(value = """
    WITH date_range AS (
        SELECT DISTINCT DATE(order_date) as date
        FROM orders
    )
    SELECT 
        COUNT(CASE WHEN o.status = 'Đã vận chuyển thành công!' THEN 1 END) as total_orders
    FROM date_range d
    LEFT JOIN orders o ON DATE(o.order_date) = d.date
    GROUP BY d.date
    ORDER BY d.date
    LIMIT 7
    """, nativeQuery = true)
    List<Integer> getOrdersComplete7Days();

    @Query(value = """
    SELECT 
        COUNT(*) as total_orders
    FROM orders
        WHERE processed = 1
    GROUP BY DATE(order_date)
    LIMIT 7
    """, nativeQuery = true)
    List<Integer> getOrders7Days();

    @Query(value = """
    WITH date_range AS (
        SELECT DISTINCT DATE(order_date) as date
        FROM orders
            WHERE MONTH(order_date) = MONTH(CURRENT_DATE())
            AND YEAR(order_date) = YEAR(CURRENT_DATE())
    )
    SELECT 
        COUNT(CASE WHEN o.status = 'Đã vận chuyển thành công!' THEN 1 END) as total_orders
    FROM date_range d
    LEFT JOIN orders o ON DATE(o.order_date) = d.date
    GROUP BY d.date
    ORDER BY d.date
    """, nativeQuery = true)
    List<Integer> getOrdersCompleteMonth();

    @Query(value = """
    SELECT 
        COUNT(*) as total_orders
    FROM orders
        WHERE MONTH(order_date) = MONTH(CURRENT_DATE())
            AND YEAR(order_date) = YEAR(CURRENT_DATE())
            AND processed = 1
    GROUP BY DATE(order_date)
    """, nativeQuery = true)
    List<Integer> getOrdersMonth();


    @Query(value = """
    WITH date_range AS (
        SELECT DISTINCT DATE(order_date) as date
        FROM orders
            WHERE MONTH(order_date) = MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH))
    )
    SELECT 
        COUNT(CASE WHEN o.status = 'Đã vận chuyển thành công!' THEN 1 END) as total_orders
    FROM date_range d
    LEFT JOIN orders o ON DATE(o.order_date) = d.date
    GROUP BY d.date
    ORDER BY d.date
    """, nativeQuery = true)
    List<Integer> getOrdersCompleteLastMonth();

    @Query(value = """
    SELECT 
        COUNT(*) as total_orders
    FROM orders
        WHERE MONTH(order_date) = MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH)) AND processed = 1
    GROUP BY DATE(order_date)
    """, nativeQuery = true)
    List<Integer> getOrdersLastMonth();

    @Query(value = """
    SELECT
        DATE_FORMAT(MIN(order_date), '%d/%m') as order_day
    FROM orders
        WHERE processed = 1
    GROUP BY DATE(order_date)
    ORDER BY DATE(order_date) ASC
    LIMIT 7
    """, nativeQuery = true)
    List<String> getOrderStats7Days();




    @Query(value = """
    WITH date_range AS (
        SELECT DISTINCT DATE(order_date) as date
        FROM orders
        ORDER BY date
    )
    SELECT
            COALESCE(SUM(o.total_price), 0) as total_price
        FROM date_range d
        LEFT JOIN orders o ON DATE(o.order_date) = d.date\s
            AND o.status = 'Đã vận chuyển thành công!'
        GROUP BY d.date
        LIMIT 7
    """, nativeQuery = true)
    List<Double> getSalesCompleteByWeek();

    @Query(value = """
    SELECT SUM(total_price) AS total
    FROM orders
        WHERE processed = 1
    GROUP BY DATE(order_date)
    LIMIT 7
    """, nativeQuery = true)
    List<Double> getSalesByWeek();




    @Query(value = """
    SELECT
        DATE_FORMAT(MIN(order_date), '%d/%m') as order_day
    FROM orders
        WHERE MONTH(order_date) = MONTH(CURRENT_DATE())
            AND YEAR(order_date) = YEAR(CURRENT_DATE())
            AND processed = 1
    GROUP BY DATE(order_date)
    ORDER BY DATE(order_date) ASC
    """, nativeQuery = true)
    List<String> getOrderStatsMonth();

    @Query(value = """
    WITH date_range AS (
        SELECT DISTINCT DATE(order_date) as date
        FROM orders
        WHERE MONTH(order_date) = MONTH(CURRENT_DATE())
        AND YEAR(order_date) = YEAR(CURRENT_DATE())
            AND processed = 1
        ORDER BY date
    )
    SELECT
        COALESCE(SUM(o.total_price), 0) as total_price
    FROM date_range d
    LEFT JOIN orders o ON DATE(o.order_date) = d.date
        AND o.status = 'Đã vận chuyển thành công!'
    GROUP BY d.date;
    """, nativeQuery = true)
    List<Double> getSalesCompleteByMonth();

    @Query(value = """
    SELECT SUM(total_price) AS total
    FROM orders
        WHERE MONTH(order_date) = MONTH(CURRENT_DATE())
            AND YEAR(order_date) = YEAR(CURRENT_DATE())
            AND processed = 1
    GROUP BY DATE(order_date)
    """, nativeQuery = true)
    List<Double> getSalesByMonth();




    @Query(value = """
    SELECT
        DATE_FORMAT(MIN(order_date), '%d/%m') as order_day
    FROM orders
        WHERE MONTH(order_date) = MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH)) AND processed = 1
    GROUP BY DATE(order_date)
    ORDER BY DATE(order_date) ASC
    """, nativeQuery = true)
    List<String> getOrderStatsLastMonth();

    @Query(value = """
    WITH date_range AS (
        SELECT DISTINCT DATE(order_date) as date
        FROM orders
        WHERE MONTH(order_date) = MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH))
        ORDER BY date
    )
    SELECT
        COALESCE(SUM(o.total_price), 0) as total_price
    FROM date_range d
    LEFT JOIN orders o ON DATE(o.order_date) = d.date
        AND o.status = 'Đã vận chuyển thành công!'
    GROUP BY d.date;
    """, nativeQuery = true)
    List<Double> getSalesCompleteByLastMonth();

    @Query(value = """
    SELECT SUM(total_price) AS total
    FROM orders
        WHERE MONTH(order_date) = MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH)) AND processed = 1
    GROUP BY DATE(order_date)
    """, nativeQuery = true)
    List<Double> getSalesByLastMonth();

    @Query(value = """
    SELECT COALESCE(SUM(total_price), 0) AS total
    FROM orders
        WHERE MONTH(order_date) = MONTH(CURRENT_DATE())
        AND status = 'Đã vận chuyển thành công!'
    """, nativeQuery = true)
    Double getTotalSalesCompleteByMonth();

    @Query(value = """
    SELECT COALESCE(SUM(total_price), 0) AS total
    FROM orders
        WHERE MONTH(order_date) = MONTH(CURRENT_DATE()) AND processed = 1
    """, nativeQuery = true)
    Double getTotalSalesByMonth();

    @Query(value = """
    SELECT COALESCE(SUM(total_price), 0) AS total
    FROM orders
        WHERE MONTH(order_date) = MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH))
        AND status = 'Đã vận chuyển thành công!'
    """, nativeQuery = true)
    Double getTotalSalesCompleteByLastMonth();

    @Query(value = """
    SELECT COALESCE(SUM(total_price), 0) AS total
    FROM orders
        WHERE MONTH(order_date) = MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH)) AND processed = 1
    """, nativeQuery = true)
    Double getTotalSalesByLastMonth();


    @Query(value = """
    SELECT 
        status
    FROM orders
        WHERE processed = 1
    GROUP BY status
    """, nativeQuery = true)
    List<String> getOrdersGroupByStatus();

    @Query(value = """
    SELECT 
        COUNT(*) as total_orders
    FROM orders
        WHERE processed = 1
    GROUP BY status
    """, nativeQuery = true)
    List<Integer> countOrdersGroupByStatus();

    @Query(value = """
    SELECT
        COALESCE(COUNT(*), 0) as total_orders
    FROM orders
        WHERE MONTH(order_date) = MONTH(CURRENT_DATE())
        AND status = 'Đã vận chuyển thành công!'
    """, nativeQuery = true)
    Integer getOrdersComplete();

    @Query(value = """
    SELECT 
        COUNT(*) as total_orders
    FROM orders
        WHERE MONTH(order_date) = MONTH(CURRENT_DATE()) AND processed = 1
    """, nativeQuery = true)
    Integer countOrdersByMonth();

    @Query("""
    SELECT 
        SUM(po.price * po.quantity)
    FROM ProductOrder po
        JOIN Orders o ON po.orderId = o.orderId
            where o.processed = true AND o.status = 'Đã vận chuyển thành công!'
    GROUP BY po.product
    ORDER BY SUM(po.price * po.quantity) DESC
    """)
    List<Double> sumTotalPriceProductTop();

    @Query("""
    SELECT 
        po.product.ten
    FROM ProductOrder po
        JOIN Orders o ON po.orderId = o.orderId
            where o.processed = true AND o.status = 'Đã vận chuyển thành công!'
    GROUP BY po.product
    ORDER BY SUM(po.price * po.quantity) DESC
    """)
    List<String> getProductsTop();

    Page<Orders> findByProcessed(Boolean processed, Pageable pageable);

    @Query("""
    SELECT
        sum(o.totalPrice)
    from Orders o
        where o.processed = true and o.status = 'Đã vận chuyển thành công!'
            group by o.user
                order by sum(o.totalPrice) desc
    """)
    List<Double> sumTotalPriceByUsers();

    @Query("""
    SELECT
        o.user.email
    from Orders o
        where o.processed = true and o.status = 'Đã vận chuyển thành công!'
            group by o.user
                order by sum(o.totalPrice) desc
    """)
    List<String> getUsersTop();
}
