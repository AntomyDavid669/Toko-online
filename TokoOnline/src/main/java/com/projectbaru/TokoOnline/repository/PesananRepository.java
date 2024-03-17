package com.projectbaru.TokoOnline.repository;

import org.springframework.stereotype.Repository;

import com.projectbaru.TokoOnline.dto.OrderInterfaceDTO;
import com.projectbaru.TokoOnline.entity.PesananEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface PesananRepository extends JpaRepository<PesananEntity, Long>{
    @Query(nativeQuery = true, value = "SELECT \r\n" + //
                "    pesanan.order_id,\r\n" + //
                "    pesanan.order_date, \r\n" + //
                "    users.nama_lengkap, \r\n" + //
                "    pesanan.total_amount, \r\n" + //
                "    product.product_name, \r\n" + //
                "    detail_pesanan.quantity, \r\n" + //
                "    detail_pesanan.subtotal\r\n" + //
                "    FROM users, pesanan, detail_pesanan, product\r\n" + //
                "    WHERE\r\n" + //
                "        pesanan.user_id = users.id AND\r\n" + //
                "        pesanan.order_id = detail_pesanan.order_id AND\r\n" + //
                "        detail_pesanan.product_id = product.product_id")
    List<OrderInterfaceDTO> getAllOrder();
    
    // Earnings monthly
    @Query("SELECT SUM(p.total_amount) FROM PesananEntity p WHERE MONTH(p.order_date) = :month")
    Double getEarningsMonthly(int month);

    // Earnings annual
    @Query("SELECT SUM(p.total_amount) FROM PesananEntity p WHERE YEAR(p.order_date) = :year")
    Double getEarningsAnnual(int year);

    // Total order monthly
    @Query("SELECT COUNT(p) FROM PesananEntity p WHERE MONTH(p.order_date) = :month")
    Long getTotalOrderMonthly(int month);

    // Total order annual
    @Query("SELECT COUNT(p) FROM PesananEntity p WHERE YEAR(p.order_date) = :year")
    Long getTotalOrderAnnual(int year);

    // Card -> earnings monthly
    // Card -> earnings annual
    // Card -> total order monthly
    // Card -> total order annual

}
