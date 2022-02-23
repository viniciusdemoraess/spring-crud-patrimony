package com.sesp.patrimonio.app.dtos;

import com.sesp.patrimonio.app.models.ImageField;

import lombok.Data;

@Data
public class ImageDTO {
    
    private String id;

    private String imageURL;

    public ImageDTO(){
        super();
    }

    public ImageDTO(ImageField obj){
        super();
        this.id = obj.getId();
        this.imageURL = obj.getImageUrl();
    }
}
