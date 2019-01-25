package com.example.restejbjpa.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Owner.class)
public class Owner_ {

    public static volatile SingularAttribute<Owner, String> name;
    public static volatile SingularAttribute<Owner, String> surname;
    public static volatile SingularAttribute<Owner, Integer> age;
}
