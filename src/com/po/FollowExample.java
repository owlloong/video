package com.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FollowExample {
    /**
     * follow
     */
    protected String orderByClause;

    /**
     * follow
     */
    protected boolean distinct;

    /**
     * follow
     */
    protected List<Criteria> oredCriteria;

    public FollowExample() {
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
     * follow 2019-04-07
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

        public Criteria andFollowIdIsNull() {
            addCriterion("followId is null");
            return (Criteria) this;
        }

        public Criteria andFollowIdIsNotNull() {
            addCriterion("followId is not null");
            return (Criteria) this;
        }

        public Criteria andFollowIdEqualTo(String value) {
            addCriterion("followId =", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotEqualTo(String value) {
            addCriterion("followId <>", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdGreaterThan(String value) {
            addCriterion("followId >", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdGreaterThanOrEqualTo(String value) {
            addCriterion("followId >=", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdLessThan(String value) {
            addCriterion("followId <", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdLessThanOrEqualTo(String value) {
            addCriterion("followId <=", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdLike(String value) {
            addCriterion("followId like", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotLike(String value) {
            addCriterion("followId not like", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdIn(List<String> values) {
            addCriterion("followId in", values, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotIn(List<String> values) {
            addCriterion("followId not in", values, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdBetween(String value1, String value2) {
            addCriterion("followId between", value1, value2, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotBetween(String value1, String value2) {
            addCriterion("followId not between", value1, value2, "followId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("userId like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("userId not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUpIdIsNull() {
            addCriterion("upId is null");
            return (Criteria) this;
        }

        public Criteria andUpIdIsNotNull() {
            addCriterion("upId is not null");
            return (Criteria) this;
        }

        public Criteria andUpIdEqualTo(String value) {
            addCriterion("upId =", value, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdNotEqualTo(String value) {
            addCriterion("upId <>", value, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdGreaterThan(String value) {
            addCriterion("upId >", value, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdGreaterThanOrEqualTo(String value) {
            addCriterion("upId >=", value, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdLessThan(String value) {
            addCriterion("upId <", value, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdLessThanOrEqualTo(String value) {
            addCriterion("upId <=", value, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdLike(String value) {
            addCriterion("upId like", value, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdNotLike(String value) {
            addCriterion("upId not like", value, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdIn(List<String> values) {
            addCriterion("upId in", values, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdNotIn(List<String> values) {
            addCriterion("upId not in", values, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdBetween(String value1, String value2) {
            addCriterion("upId between", value1, value2, "upId");
            return (Criteria) this;
        }

        public Criteria andUpIdNotBetween(String value1, String value2) {
            addCriterion("upId not between", value1, value2, "upId");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIsNull() {
            addCriterion("followTime is null");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIsNotNull() {
            addCriterion("followTime is not null");
            return (Criteria) this;
        }

        public Criteria andFollowTimeEqualTo(Date value) {
            addCriterion("followTime =", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotEqualTo(Date value) {
            addCriterion("followTime <>", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeGreaterThan(Date value) {
            addCriterion("followTime >", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("followTime >=", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeLessThan(Date value) {
            addCriterion("followTime <", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeLessThanOrEqualTo(Date value) {
            addCriterion("followTime <=", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIn(List<Date> values) {
            addCriterion("followTime in", values, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotIn(List<Date> values) {
            addCriterion("followTime not in", values, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeBetween(Date value1, Date value2) {
            addCriterion("followTime between", value1, value2, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotBetween(Date value1, Date value2) {
            addCriterion("followTime not between", value1, value2, "followTime");
            return (Criteria) this;
        }
    }

    /**
     * 描述:follow表的实体类
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
     * follow 2019-04-07
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