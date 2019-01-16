package com.vwmarket.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vwmarketbackend.dto.Product;

public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")){
            errors.rejectValue("file", null, "Please select image file to upload");
            return;
        }

        if(!product.getFile().getContentType().equals("image/jpeg") ||
                !product.getFile().getContentType().equals("image/png") ||
                !product.getFile().getContentType().equals("image/gif")){
            }
            errors.rejectValue("file", null, "Please use only image file for upload");
            return;
    }
}
