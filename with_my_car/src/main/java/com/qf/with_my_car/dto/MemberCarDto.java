package com.qf.with_my_car.dto;

import lombok.Data;

@Data
public class MemberCarDto {
    private Long memberCarId;
    private String brandName;
    private String makeName;
    private String modelName;
    private String carName;
    private String buyYear;
    private String currentMileage;
    private String remark;
    private String type;
    private String image;

    public MemberCarDto() {
    }

    public MemberCarDto(Long memberCarId, String brandName, String makeName, String modelName, String carName, String buyYear, String currentMileage, String remark, String type, String image) {
        this.memberCarId = memberCarId;
        this.brandName = brandName;
        this.makeName = makeName;
        this.modelName = modelName;
        this.carName = carName;
        this.buyYear = buyYear;
        this.currentMileage = currentMileage;
        this.remark = remark;
        this.type = type;
        this.image = image;
    }
}
