package com.zzd.news.pojo;

import java.util.ArrayList;
import java.util.List;

public class NewsDictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsDictExample() {
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

        public Criteria andNewsIdIsNull() {
            addCriterion("news_id is null");
            return (Criteria) this;
        }

        public Criteria andNewsIdIsNotNull() {
            addCriterion("news_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewsIdEqualTo(Integer value) {
            addCriterion("news_id =", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotEqualTo(Integer value) {
            addCriterion("news_id <>", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThan(Integer value) {
            addCriterion("news_id >", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_id >=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThan(Integer value) {
            addCriterion("news_id <", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThanOrEqualTo(Integer value) {
            addCriterion("news_id <=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdIn(List<Integer> values) {
            addCriterion("news_id in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotIn(List<Integer> values) {
            addCriterion("news_id not in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdBetween(Integer value1, Integer value2) {
            addCriterion("news_id between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("news_id not between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNull() {
            addCriterion("news_title is null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNotNull() {
            addCriterion("news_title is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleEqualTo(String value) {
            addCriterion("news_title =", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotEqualTo(String value) {
            addCriterion("news_title <>", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThan(String value) {
            addCriterion("news_title >", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("news_title >=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThan(String value) {
            addCriterion("news_title <", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThanOrEqualTo(String value) {
            addCriterion("news_title <=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLike(String value) {
            addCriterion("news_title like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotLike(String value) {
            addCriterion("news_title not like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIn(List<String> values) {
            addCriterion("news_title in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotIn(List<String> values) {
            addCriterion("news_title not in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleBetween(String value1, String value2) {
            addCriterion("news_title between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotBetween(String value1, String value2) {
            addCriterion("news_title not between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTextIsNull() {
            addCriterion("news_text is null");
            return (Criteria) this;
        }

        public Criteria andNewsTextIsNotNull() {
            addCriterion("news_text is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTextEqualTo(String value) {
            addCriterion("news_text =", value, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextNotEqualTo(String value) {
            addCriterion("news_text <>", value, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextGreaterThan(String value) {
            addCriterion("news_text >", value, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextGreaterThanOrEqualTo(String value) {
            addCriterion("news_text >=", value, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextLessThan(String value) {
            addCriterion("news_text <", value, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextLessThanOrEqualTo(String value) {
            addCriterion("news_text <=", value, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextLike(String value) {
            addCriterion("news_text like", value, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextNotLike(String value) {
            addCriterion("news_text not like", value, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextIn(List<String> values) {
            addCriterion("news_text in", values, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextNotIn(List<String> values) {
            addCriterion("news_text not in", values, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextBetween(String value1, String value2) {
            addCriterion("news_text between", value1, value2, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsTextNotBetween(String value1, String value2) {
            addCriterion("news_text not between", value1, value2, "newsText");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherIsNull() {
            addCriterion("news_publisher is null");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherIsNotNull() {
            addCriterion("news_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherEqualTo(String value) {
            addCriterion("news_publisher =", value, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherNotEqualTo(String value) {
            addCriterion("news_publisher <>", value, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherGreaterThan(String value) {
            addCriterion("news_publisher >", value, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("news_publisher >=", value, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherLessThan(String value) {
            addCriterion("news_publisher <", value, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherLessThanOrEqualTo(String value) {
            addCriterion("news_publisher <=", value, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherLike(String value) {
            addCriterion("news_publisher like", value, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherNotLike(String value) {
            addCriterion("news_publisher not like", value, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherIn(List<String> values) {
            addCriterion("news_publisher in", values, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherNotIn(List<String> values) {
            addCriterion("news_publisher not in", values, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherBetween(String value1, String value2) {
            addCriterion("news_publisher between", value1, value2, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsPublisherNotBetween(String value1, String value2) {
            addCriterion("news_publisher not between", value1, value2, "newsPublisher");
            return (Criteria) this;
        }

        public Criteria andNewsImgIsNull() {
            addCriterion("news_img is null");
            return (Criteria) this;
        }

        public Criteria andNewsImgIsNotNull() {
            addCriterion("news_img is not null");
            return (Criteria) this;
        }

        public Criteria andNewsImgEqualTo(String value) {
            addCriterion("news_img =", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgNotEqualTo(String value) {
            addCriterion("news_img <>", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgGreaterThan(String value) {
            addCriterion("news_img >", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgGreaterThanOrEqualTo(String value) {
            addCriterion("news_img >=", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgLessThan(String value) {
            addCriterion("news_img <", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgLessThanOrEqualTo(String value) {
            addCriterion("news_img <=", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgLike(String value) {
            addCriterion("news_img like", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgNotLike(String value) {
            addCriterion("news_img not like", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgIn(List<String> values) {
            addCriterion("news_img in", values, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgNotIn(List<String> values) {
            addCriterion("news_img not in", values, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgBetween(String value1, String value2) {
            addCriterion("news_img between", value1, value2, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgNotBetween(String value1, String value2) {
            addCriterion("news_img not between", value1, value2, "newsImg");
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