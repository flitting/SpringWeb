package com.example.demo.domain;

import org.springframework.http.HttpStatus;

import java.io.Serializable;


// generate unit test: ctrl + shift + t
public class JsonResp<T> implements Serializable {
    int status;
    String message;

    T data;

    public static class Builder<T> {
        int status;
        String message;
        T data;

        public Builder<T> status(int status) {
            this.status = status;
            return this;
        }

        public Builder<T> status(HttpStatus httpStatus) {
            this.status = httpStatus.value();
            return this;
        }

        public Builder<T> ok() {
            this.status = HttpStatus.OK.value(); // 200
            return this;
        }

        public Builder<T> error() {
            this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public <O extends T> Builder<T> data(O data) {
            this.data = data;
            return this;
        }

        public JsonResp<T> build() {
            return new JsonResp<T>(this);
        }
    }

    // 泛型擦除， 此时的T是Object类型
    public static JsonResp.Builder builder() {
        return new JsonResp.Builder();
    }

    // 有泛型。V类型的Builder
    public static <V> JsonResp.Builder<V> builder(Class<? extends V> clazz) {
        return new JsonResp.Builder<V>();
    }

    private JsonResp(Builder<T> builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.data = builder.data;
    }

    @Override
    public String toString() {
        return "JsonResp{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
