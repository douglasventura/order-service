package com.douglasventura.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.douglasventura.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
  private Instant date;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

  private Integer orderStatus;

  @OneToMany(mappedBy = "id.order")
  private Set<OrderItem> items = new HashSet<>();

  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
  private Payment payment;

  // empty constructor
  public Order() {
  }

  public Order(Long id, Instant date, User client, OrderStatus orderStatus) {
    super();
    this.id = id;
    this.date = date;
    this.client = client;
    setOrderStatus(orderStatus);
  }

  public OrderStatus getOrderStatus() {
    return OrderStatus.valueOf(orderStatus);
  }

  private void setOrderStatus(OrderStatus orderStatus) {
    if (orderStatus != null) {
      this.orderStatus = orderStatus.getCode();
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  public Set<OrderItem> getItems() {
    return items;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public Double getTotal() {
    Double total = 0.0;

    for (OrderItem orderItem : items) {
      total += orderItem.getSubTotal();
    }

    return total;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
