package com.shangyi.${project}.infrastructrue.repository${module};

import com.shangyi.${project}.dao.entity${module}.${className}Entity;
import com.shangyi.${project}.dao.repository${module}.I${className}EntityRepository;
import com.shangyi.${project}.domain.model${module}.${className};
import com.shangyi.${project}.domain.repository${module}.I${className}Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ${className}Repository implements I${className}Repository {

    @Autowired
    I${className}EntityRepository ${lowerClassName}EntityRepository;

    @Override
    public void add(${className} model) {

    }

    @Override
    public void update(${className} model) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public ${className} get(String s) {
        return null;
    }


    private ${className}Entity map(${className} model, ${className}Entity oldEntity) {
        ${className}Entity ${lowerClassName}Entity = oldEntity;

        if (oldEntity == null) {
            ${lowerClassName}Entity = new ${className}Entity();
        }

        BeanUtils.copyProperties(model, ${lowerClassName}Entity);

        return ${lowerClassName}Entity;
    }

}
