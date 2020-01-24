package com.zeno.calendar.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReminderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReminderExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andRemindTextIsNull() {
            addCriterion("Remind_Text is null");
            return (Criteria) this;
        }

        public Criteria andRemindTextIsNotNull() {
            addCriterion("Remind_Text is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTextEqualTo(String value) {
            addCriterion("Remind_Text =", value, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextNotEqualTo(String value) {
            addCriterion("Remind_Text <>", value, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextGreaterThan(String value) {
            addCriterion("Remind_Text >", value, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextGreaterThanOrEqualTo(String value) {
            addCriterion("Remind_Text >=", value, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextLessThan(String value) {
            addCriterion("Remind_Text <", value, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextLessThanOrEqualTo(String value) {
            addCriterion("Remind_Text <=", value, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextLike(String value) {
            addCriterion("Remind_Text like", value, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextNotLike(String value) {
            addCriterion("Remind_Text not like", value, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextIn(List<String> values) {
            addCriterion("Remind_Text in", values, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextNotIn(List<String> values) {
            addCriterion("Remind_Text not in", values, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextBetween(String value1, String value2) {
            addCriterion("Remind_Text between", value1, value2, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindTextNotBetween(String value1, String value2) {
            addCriterion("Remind_Text not between", value1, value2, "remindText");
            return (Criteria) this;
        }

        public Criteria andRemindDayIsNull() {
            addCriterion("Remind_Day is null");
            return (Criteria) this;
        }

        public Criteria andRemindDayIsNotNull() {
            addCriterion("Remind_Day is not null");
            return (Criteria) this;
        }

        public Criteria andRemindDayEqualTo(Date value) {
            addCriterionForJDBCDate("Remind_Day =", value, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("Remind_Day <>", value, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayGreaterThan(Date value) {
            addCriterionForJDBCDate("Remind_Day >", value, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Remind_Day >=", value, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayLessThan(Date value) {
            addCriterionForJDBCDate("Remind_Day <", value, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Remind_Day <=", value, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayIn(List<Date> values) {
            addCriterionForJDBCDate("Remind_Day in", values, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("Remind_Day not in", values, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Remind_Day between", value1, value2, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Remind_Day not between", value1, value2, "remindDay");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNull() {
            addCriterion("Remind_Time is null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNotNull() {
            addCriterion("Remind_Time is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeEqualTo(Date value) {
            addCriterionForJDBCTime("Remind_Time =", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("Remind_Time <>", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("Remind_Time >", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("Remind_Time >=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThan(Date value) {
            addCriterionForJDBCTime("Remind_Time <", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("Remind_Time <=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIn(List<Date> values) {
            addCriterionForJDBCTime("Remind_Time in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("Remind_Time not in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("Remind_Time between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("Remind_Time not between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRepetitionIsNull() {
            addCriterion("Repetition is null");
            return (Criteria) this;
        }

        public Criteria andRepetitionIsNotNull() {
            addCriterion("Repetition is not null");
            return (Criteria) this;
        }

        public Criteria andRepetitionEqualTo(Integer value) {
            addCriterion("Repetition =", value, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionNotEqualTo(Integer value) {
            addCriterion("Repetition <>", value, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionGreaterThan(Integer value) {
            addCriterion("Repetition >", value, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionGreaterThanOrEqualTo(Integer value) {
            addCriterion("Repetition >=", value, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionLessThan(Integer value) {
            addCriterion("Repetition <", value, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionLessThanOrEqualTo(Integer value) {
            addCriterion("Repetition <=", value, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionIn(List<Integer> values) {
            addCriterion("Repetition in", values, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionNotIn(List<Integer> values) {
            addCriterion("Repetition not in", values, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionBetween(Integer value1, Integer value2) {
            addCriterion("Repetition between", value1, value2, "repetition");
            return (Criteria) this;
        }

        public Criteria andRepetitionNotBetween(Integer value1, Integer value2) {
            addCriterion("Repetition not between", value1, value2, "repetition");
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