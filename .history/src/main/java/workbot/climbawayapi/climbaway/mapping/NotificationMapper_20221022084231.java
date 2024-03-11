package workbot.climbawayapi.climbaway.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import workbot.climbawayapi.climbaway.domain.model.entity.Notification;
import workbot.climbawayapi.climbaway.resource.No;
import workbot.climbawayapi.climbaway.resource.SaveCategoryResource;
import workbot.climbawayapi.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping

    public CategoryResource toResource(Category model){
        return mapper.map(model, CategoryResource.class);
    }

    public Category toModel(CategoryResource resource) {
        return mapper.map(resource, Category.class);
    }

    public Category toModelSaveResource(SaveCategoryResource resource) {
        return mapper.map(resource, Category.class);
    }

    //List Mapping

    public List<CategoryResource> toResource(List<Category> models){
        return models.stream().map(this::toResource).collect(Collectors.toList());
    }
}