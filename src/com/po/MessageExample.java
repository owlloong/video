package com.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    /**
     * message
     */
    protected String orderByClause;

    /**
     * message
     */
    protected boolean distinct;

    /**
     * message
     */
    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

    /**
     * message 2019-04-07
     */
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

        public Criteria andMessageIdIsNull() {
            addCriterion("messageId is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("messageId is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(String value) {
            addCriterion("messageId =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(String value) {
            addCriterion("messageId <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(String value) {
            addCriterion("messageId >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(String value) {
            addCriterion("messageId >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(String value) {
            addCriterion("messageId <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(String value) {
            addCriterion("messageId <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLike(String value) {
            addCriterion("messageId like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotLike(String value) {
            addCriterion("messageId not like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<String> values) {
            addCriterion("messageId in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<String> values) {
            addCriterion("messageId not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(String value1, String value2) {
            addCriterion("messageId between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(String value1, String value2) {
            addCriterion("messageId not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNull() {
            addCriterion("sendId is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("sendId is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(String value) {
            addCriterion("sendId =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(String value) {
            addCriterion("sendId <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(String value) {
            addCriterion("sendId >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(String value) {
            addCriterion("sendId >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(String value) {
            addCriterion("sendId <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(String value) {
            addCriterion("sendId <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLike(String value) {
            addCriterion("sendId like", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotLike(String value) {
            addCriterion("sendId not like", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<String> values) {
            addCriterion("sendId in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<String> values) {
            addCriterion("sendId not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(String value1, String value2) {
            addCriterion("sendId between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(String value1, String value2) {
            addCriterion("sendId not between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIsNull() {
            addCriterion("receiveId is null");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIsNotNull() {
            addCriterion("receiveId is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveIdEqualTo(String value) {
            addCriterion("receiveId =", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotEqualTo(String value) {
            addCriterion("receiveId <>", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdGreaterThan(String value) {
            addCriterion("receiveId >", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdGreaterThanOrEqualTo(String value) {
            addCriterion("receiveId >=", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdLessThan(String value) {
            addCriterion("receiveId <", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdLessThanOrEqualTo(String value) {
            addCriterion("receiveId <=", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdLike(String value) {
            addCriterion("receiveId like", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotLike(String value) {
            addCriterion("receiveId not like", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIn(List<String> values) {
            addCriterion("receiveId in", values, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotIn(List<String> values) {
            addCriterion("receiveId not in", values, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdBetween(String value1, String value2) {
            addCriterion("receiveId between", value1, value2, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotBetween(String value1, String value2) {
            addCriterion("receiveId not between", value1, value2, "receiveId");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIsNull() {
            addCriterion("messageTime is null");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIsNotNull() {
            addCriterion("messageTime is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTimeEqualTo(Date value) {
            addCriterion("messageTime =", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotEqualTo(Date value) {
            addCriterion("messageTime <>", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeGreaterThan(Date value) {
            addCriterion("messageTime >", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("messageTime >=", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLessThan(Date value) {
            addCriterion("messageTime <", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLessThanOrEqualTo(Date value) {
            addCriterion("messageTime <=", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIn(List<Date> values) {
            addCriterion("messageTime in", values, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotIn(List<Date> values) {
            addCriterion("messageTime not in", values, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeBetween(Date value1, Date value2) {
            addCriterion("messageTime between", value1, value2, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotBetween(Date value1, Date value2) {
            addCriterion("messageTime not between", value1, value2, "messageTime");
            return (Criteria) this;
        }
    }

    /**
     * 描述:message表的实体类
     * @version
     * @author:  Administrator
     * @创建时间: 2019-04-07
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * message 2019-04-07
     */
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