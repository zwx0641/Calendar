package com.zeno.calendar.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EventReminderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EventReminderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andReminderTextIsNull() {
            addCriterion("reminder_text is null");
            return (Criteria) this;
        }

        public Criteria andReminderTextIsNotNull() {
            addCriterion("reminder_text is not null");
            return (Criteria) this;
        }

        public Criteria andReminderTextEqualTo(String value) {
            addCriterion("reminder_text =", value, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextNotEqualTo(String value) {
            addCriterion("reminder_text <>", value, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextGreaterThan(String value) {
            addCriterion("reminder_text >", value, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextGreaterThanOrEqualTo(String value) {
            addCriterion("reminder_text >=", value, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextLessThan(String value) {
            addCriterion("reminder_text <", value, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextLessThanOrEqualTo(String value) {
            addCriterion("reminder_text <=", value, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextLike(String value) {
            addCriterion("reminder_text like", value, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextNotLike(String value) {
            addCriterion("reminder_text not like", value, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextIn(List<String> values) {
            addCriterion("reminder_text in", values, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextNotIn(List<String> values) {
            addCriterion("reminder_text not in", values, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextBetween(String value1, String value2) {
            addCriterion("reminder_text between", value1, value2, "reminderText");
            return (Criteria) this;
        }

        public Criteria andReminderTextNotBetween(String value1, String value2) {
            addCriterion("reminder_text not between", value1, value2, "reminderText");
            return (Criteria) this;
        }

        public Criteria andSpecificDayIsNull() {
            addCriterion("specific_day is null");
            return (Criteria) this;
        }

        public Criteria andSpecificDayIsNotNull() {
            addCriterion("specific_day is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificDayEqualTo(Date value) {
            addCriterionForJDBCDate("specific_day =", value, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("specific_day <>", value, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayGreaterThan(Date value) {
            addCriterionForJDBCDate("specific_day >", value, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("specific_day >=", value, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayLessThan(Date value) {
            addCriterionForJDBCDate("specific_day <", value, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("specific_day <=", value, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayIn(List<Date> values) {
            addCriterionForJDBCDate("specific_day in", values, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("specific_day not in", values, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("specific_day between", value1, value2, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("specific_day not between", value1, value2, "specificDay");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeIsNull() {
            addCriterion("specific_time is null");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeIsNotNull() {
            addCriterion("specific_time is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeEqualTo(Date value) {
            addCriterionForJDBCTime("specific_time =", value, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("specific_time <>", value, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("specific_time >", value, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("specific_time >=", value, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeLessThan(Date value) {
            addCriterionForJDBCTime("specific_time <", value, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("specific_time <=", value, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeIn(List<Date> values) {
            addCriterionForJDBCTime("specific_time in", values, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("specific_time not in", values, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("specific_time between", value1, value2, "specificTime");
            return (Criteria) this;
        }

        public Criteria andSpecificTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("specific_time not between", value1, value2, "specificTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}