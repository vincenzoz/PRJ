//package org.vinsw.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity
//public class Student extends Person {
//
//    @Id
//    private Long id;
//    private String name;
//    private String passportNumber;
//
//
//    public static class Builder extends Person.Builder<Builder> {
//        private String passportNumber;
//
//        public Builder passportNumber(String passportNumber) {
//            this.passportNumber = passportNumber;
//            return this;
//        }
//
//        @Override
//        public Student build() {
//            return new Student(this);
//        }
//
//        @Override
//        protected Builder self() {
//            return this;
//        }
//    }
//
//    private Student(Builder builder) {
//        super(builder);
//        passportNumber = builder.passportNumber;
//    }
//
//}
