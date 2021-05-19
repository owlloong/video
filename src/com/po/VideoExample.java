package com.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoExample {
    /**
     * video
     */
    protected String orderByClause;

    /**
     * video
     */
    protected boolean distinct;

    /**
     * video
     */
    protected List<Criteria> oredCriteria;

    public VideoExample() {
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
     * video 2019-04-07
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

        public Criteria andVideoIdIsNull() {
            addCriterion("videoId is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNotNull() {
            addCriterion("videoId is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdEqualTo(String value) {
            addCriterion("videoId =", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotEqualTo(String value) {
            addCriterion("videoId <>", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThan(String value) {
            addCriterion("videoId >", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThanOrEqualTo(String value) {
            addCriterion("videoId >=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThan(String value) {
            addCriterion("videoId <", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThanOrEqualTo(String value) {
            addCriterion("videoId <=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLike(String value) {
            addCriterion("videoId like", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotLike(String value) {
            addCriterion("videoId not like", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIn(List<String> values) {
            addCriterion("videoId in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotIn(List<String> values) {
            addCriterion("videoId not in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdBetween(String value1, String value2) {
            addCriterion("videoId between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotBetween(String value1, String value2) {
            addCriterion("videoId not between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNull() {
            addCriterion("videoName is null");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNotNull() {
            addCriterion("videoName is not null");
            return (Criteria) this;
        }

        public Criteria andVideoNameEqualTo(String value) {
            addCriterion("videoName =", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotEqualTo(String value) {
            addCriterion("videoName <>", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThan(String value) {
            addCriterion("videoName >", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThanOrEqualTo(String value) {
            addCriterion("videoName >=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThan(String value) {
            addCriterion("videoName <", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThanOrEqualTo(String value) {
            addCriterion("videoName <=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLike(String value) {
            addCriterion("videoName like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotLike(String value) {
            addCriterion("videoName not like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameIn(List<String> values) {
            addCriterion("videoName in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotIn(List<String> values) {
            addCriterion("videoName not in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameBetween(String value1, String value2) {
            addCriterion("videoName between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotBetween(String value1, String value2) {
            addCriterion("videoName not between", value1, value2, "videoName");
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

        public Criteria andVideoURLIsNull() {
            addCriterion("videoURL is null");
            return (Criteria) this;
        }

        public Criteria andVideoURLIsNotNull() {
            addCriterion("videoURL is not null");
            return (Criteria) this;
        }

        public Criteria andVideoURLEqualTo(String value) {
            addCriterion("videoURL =", value, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLNotEqualTo(String value) {
            addCriterion("videoURL <>", value, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLGreaterThan(String value) {
            addCriterion("videoURL >", value, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLGreaterThanOrEqualTo(String value) {
            addCriterion("videoURL >=", value, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLLessThan(String value) {
            addCriterion("videoURL <", value, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLLessThanOrEqualTo(String value) {
            addCriterion("videoURL <=", value, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLLike(String value) {
            addCriterion("videoURL like", value, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLNotLike(String value) {
            addCriterion("videoURL not like", value, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLIn(List<String> values) {
            addCriterion("videoURL in", values, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLNotIn(List<String> values) {
            addCriterion("videoURL not in", values, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLBetween(String value1, String value2) {
            addCriterion("videoURL between", value1, value2, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoURLNotBetween(String value1, String value2) {
            addCriterion("videoURL not between", value1, value2, "videoURL");
            return (Criteria) this;
        }

        public Criteria andVideoSRCIsNull() {
            addCriterion("videoSRC is null");
            return (Criteria) this;
        }

        public Criteria andVideoSRCIsNotNull() {
            addCriterion("videoSRC is not null");
            return (Criteria) this;
        }

        public Criteria andVideoSRCEqualTo(String value) {
            addCriterion("videoSRC =", value, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCNotEqualTo(String value) {
            addCriterion("videoSRC <>", value, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCGreaterThan(String value) {
            addCriterion("videoSRC >", value, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCGreaterThanOrEqualTo(String value) {
            addCriterion("videoSRC >=", value, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCLessThan(String value) {
            addCriterion("videoSRC <", value, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCLessThanOrEqualTo(String value) {
            addCriterion("videoSRC <=", value, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCLike(String value) {
            addCriterion("videoSRC like", value, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCNotLike(String value) {
            addCriterion("videoSRC not like", value, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCIn(List<String> values) {
            addCriterion("videoSRC in", values, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCNotIn(List<String> values) {
            addCriterion("videoSRC not in", values, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCBetween(String value1, String value2) {
            addCriterion("videoSRC between", value1, value2, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoSRCNotBetween(String value1, String value2) {
            addCriterion("videoSRC not between", value1, value2, "videoSRC");
            return (Criteria) this;
        }

        public Criteria andVideoTimeIsNull() {
            addCriterion("videoTime is null");
            return (Criteria) this;
        }

        public Criteria andVideoTimeIsNotNull() {
            addCriterion("videoTime is not null");
            return (Criteria) this;
        }

        public Criteria andVideoTimeEqualTo(Date value) {
            addCriterion("videoTime =", value, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeNotEqualTo(Date value) {
            addCriterion("videoTime <>", value, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeGreaterThan(Date value) {
            addCriterion("videoTime >", value, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("videoTime >=", value, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeLessThan(Date value) {
            addCriterion("videoTime <", value, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeLessThanOrEqualTo(Date value) {
            addCriterion("videoTime <=", value, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeIn(List<Date> values) {
            addCriterion("videoTime in", values, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeNotIn(List<Date> values) {
            addCriterion("videoTime not in", values, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeBetween(Date value1, Date value2) {
            addCriterion("videoTime between", value1, value2, "videoTime");
            return (Criteria) this;
        }

        public Criteria andVideoTimeNotBetween(Date value1, Date value2) {
            addCriterion("videoTime not between", value1, value2, "videoTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Long value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Long value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Long value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Long value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Long value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Long value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Long> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Long> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Long value1, Long value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Long value1, Long value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }
    }

    /**
     * 描述:video表的实体类
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
     * video 2019-04-07
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