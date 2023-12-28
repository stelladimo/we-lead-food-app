package com.example.weleadfoodapp.model;

        import lombok.Builder;
        import lombok.Getter;
        import lombok.Setter;
        import lombok.ToString;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class StoreCategory extends BaseModel {
    private String description;
}