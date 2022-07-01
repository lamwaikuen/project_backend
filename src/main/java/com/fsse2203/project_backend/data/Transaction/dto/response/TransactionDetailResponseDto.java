package com.fsse2203.project_backend.data.Transaction.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2203.project_backend.data.Transaction.Status;
import com.fsse2203.project_backend.data.Transaction.TransactionDetailData;
import com.fsse2203.project_backend.data.Transaction.TransactionProductDetailData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionDetailResponseDto {
    @JsonProperty("tid")
    private Integer tid;
    @JsonProperty("buyer_Uid")
    private Integer buyerUid;
    @JsonProperty("Date_Time")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd'TIME:'HH:mm:ss")
    private LocalDateTime dateTime;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("total_price")
    private Double totalprice;
    @JsonProperty("item")
    private List<TransactionProductResponseDto> transactionProducts=new ArrayList<>();


    public TransactionDetailResponseDto(TransactionDetailData data) {
        this.tid=data.getTid();
        this.buyerUid=data.getUser().getUid();
        this.dateTime=data.getDateTime();
        this.status=data.getStatus();
        this.totalprice=data.getTotalprice();
        setTransactionProducts(data.getTransactionProduct());
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getBuyerUid() {
        return buyerUid;
    }

    public void setBuyerUid(Integer buyerUid) {
        this.buyerUid = buyerUid;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public List<TransactionProductResponseDto> getTransactionProducts() {
        return transactionProducts;
    }

    public void setTransactionProducts(List<TransactionProductDetailData> data) {
      for (TransactionProductDetailData transactionProductDetailData:data){
          this.transactionProducts.add(new TransactionProductResponseDto(transactionProductDetailData));
      }
    }
}
