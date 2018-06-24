package com.rest.automation.admin.da.api.test;

import com.rest.automation.admin.da.domain.CategoryDomain;
import com.rest.automation.admin.da.domain.DishDomain;
import com.rest.automation.admin.da.mapper.impl.CategoryMapper;
import com.rest.automation.admin.da.mapper.impl.DishMapper;
import com.rest.automation.admin.dto.DishDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class DishMapperUnitTest {

    @Test
    public void testMapper() {
        DishMapper dishMapper = new DishMapper(new CategoryMapper());
        DishDomain dishDomain = new DishDomain();
        dishDomain.setStatus(false);
        dishDomain.setPrice(23.4);
        dishDomain.setImage(null);
        dishDomain.setDishName("Mercimek Çorbası");
        dishDomain.setDiscount(0);
        dishDomain.setDescription("Description");
        dishDomain.setCategory(new CategoryDomain(1L, "Çorbalar", null, true));
        dishDomain.setCalories(80L);
        dishDomain.setAvgCookingTime(10);

        DishDto dto = dishMapper.domainToDto(dishDomain);

        Assert.assertNotNull(dto);
    }
}
