package com.zzd.news.pojo;

import java.util.ArrayList;
import java.util.List;

public class NewsCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsCommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andConmmentTextIsNull() {
            addCriterion("conmment_text is null");
            return (Criteria) this;
        }

        public Criteria andConmmentTextIsNotNull() {
            addCriterion("conmment_text is not null");
            return (Criteria) this;
        }

        public Criteria andConmmentTextEqualTo(String value) {
            addCriterion("conmment_text =", value, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextNotEqualTo(String value) {
            addCriterion("conmment_text <>", value, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextGreaterThan(String value) {
            addCriterion("conmment_text >", value, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextGreaterThanOrEqualTo(String value) {
            addCriterion("conmment_text >=", value, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextLessThan(String value) {
            addCriterion("conmment_text <", value, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextLessThanOrEqualTo(String value) {
            addCriterion("conmment_text <=", value, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextLike(String value) {
            addCriterion("conmment_text like", value, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextNotLike(String value) {
            addCriterion("conmment_text not like", value, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextIn(List<String> values) {
            addCriterion("conmment_text in", values, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextNotIn(List<String> values) {
            addCriterion("conmment_text not in", values, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextBetween(String value1, String value2) {
            addCriterion("conmment_text between", value1, value2, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andConmmentTextNotBetween(String value1, String value2) {
            addCriterion("conmment_text not between", value1, value2, "conmmentText");
            return (Criteria) this;
        }

        public Criteria andPicUrlsIsNull() {
            addCriterion("pic_urls is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlsIsNotNull() {
            addCriterion("pic_urls is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlsEqualTo(String value) {
            addCriterion("pic_urls =", value, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsNotEqualTo(String value) {
            addCriterion("pic_urls <>", value, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsGreaterThan(String value) {
            addCriterion("pic_urls >", value, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("pic_urls >=", value, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsLessThan(String value) {
            addCriterion("pic_urls <", value, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsLessThanOrEqualTo(String value) {
            addCriterion("pic_urls <=", value, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsLike(String value) {
            addCriterion("pic_urls like", value, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsNotLike(String value) {
            addCriterion("pic_urls not like", value, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsIn(List<String> values) {
            addCriterion("pic_urls in", values, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsNotIn(List<String> values) {
            addCriterion("pic_urls not in", values, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsBetween(String value1, String value2) {
            addCriterion("pic_urls between", value1, value2, "picUrls");
            return (Criteria) this;
        }

        public Criteria andPicUrlsNotBetween(String value1, String value2) {
            addCriterion("pic_urls not between", value1, value2, "picUrls");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherIsNull() {
            addCriterion("comment_publisher is null");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherIsNotNull() {
            addCriterion("comment_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherEqualTo(String value) {
            addCriterion("comment_publisher =", value, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherNotEqualTo(String value) {
            addCriterion("comment_publisher <>", value, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherGreaterThan(String value) {
            addCriterion("comment_publisher >", value, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("comment_publisher >=", value, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherLessThan(String value) {
            addCriterion("comment_publisher <", value, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherLessThanOrEqualTo(String value) {
            addCriterion("comment_publisher <=", value, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherLike(String value) {
            addCriterion("comment_publisher like", value, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherNotLike(String value) {
            addCriterion("comment_publisher not like", value, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherIn(List<String> values) {
            addCriterion("comment_publisher in", values, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherNotIn(List<String> values) {
            addCriterion("comment_publisher not in", values, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherBetween(String value1, String value2) {
            addCriterion("comment_publisher between", value1, value2, "commentPublisher");
            return (Criteria) this;
        }

        public Criteria andCommentPublisherNotBetween(String value1, String value2) {
            addCriterion("comment_publisher not between", value1, value2, "commentPublisher");
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