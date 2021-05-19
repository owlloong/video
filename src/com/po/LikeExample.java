package com.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LikeExample {
    /**
     * like
     */
    protected String orderByClause;

    /**
     * like
     */
    protected boolean distinct;

    /**
     * like
     */
    protected List<Criteria> oredCriteria;

    public LikeExample() {
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
     * like 2019-04-07
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

        public Criteria andLikeIdIsNull() {
            addCriterion("likeId is null");
            return (Criteria) this;
        }

        public Criteria andLikeIdIsNotNull() {
            addCriterion("likeId is not null");
            return (Criteria) this;
        }

        public Criteria andLikeIdEqualTo(String value) {
            addCriterion("likeId =", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotEqualTo(String value) {
            addCriterion("likeId <>", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdGreaterThan(String value) {
            addCriterion("likeId >", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdGreaterThanOrEqualTo(String value) {
            addCriterion("likeId >=", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLessThan(String value) {
            addCriterion("likeId <", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLessThanOrEqualTo(String value) {
            addCriterion("likeId <=", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLike(String value) {
            addCriterion("likeId like", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotLike(String value) {
            addCriterion("likeId not like", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdIn(List<String> values) {
            addCriterion("likeId in", values, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotIn(List<String> values) {
            addCriterion("likeId not in", values, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdBetween(String value1, String value2) {
            addCriterion("likeId between", value1, value2, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotBetween(String value1, String value2) {
            addCriterion("likeId not between", value1, value2, "likeId");
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

        public Criteria andLikeTypeIsNull() {
            addCriterion("likeType is null");
            return (Criteria) this;
        }

        public Criteria andLikeTypeIsNotNull() {
            addCriterion("likeType is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTypeEqualTo(Integer value) {
            addCriterion("likeType =", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeNotEqualTo(Integer value) {
            addCriterion("likeType <>", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeGreaterThan(Integer value) {
            addCriterion("likeType >", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("likeType >=", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeLessThan(Integer value) {
            addCriterion("likeType <", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("likeType <=", value, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeIn(List<Integer> values) {
            addCriterion("likeType in", values, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeNotIn(List<Integer> values) {
            addCriterion("likeType not in", values, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeBetween(Integer value1, Integer value2) {
            addCriterion("likeType between", value1, value2, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("likeType not between", value1, value2, "likeType");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNull() {
            addCriterion("likeTime is null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNotNull() {
            addCriterion("likeTime is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeEqualTo(Date value) {
            addCriterion("likeTime =", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotEqualTo(Date value) {
            addCriterion("likeTime <>", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThan(Date value) {
            addCriterion("likeTime >", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("likeTime >=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThan(Date value) {
            addCriterion("likeTime <", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThanOrEqualTo(Date value) {
            addCriterion("likeTime <=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIn(List<Date> values) {
            addCriterion("likeTime in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotIn(List<Date> values) {
            addCriterion("likeTime not in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeBetween(Date value1, Date value2) {
            addCriterion("likeTime between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotBetween(Date value1, Date value2) {
            addCriterion("likeTime not between", value1, value2, "likeTime");
            return (Criteria) this;
        }
    }

    /**
     * 描述:like表的实体类
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
     * like 2019-04-07
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