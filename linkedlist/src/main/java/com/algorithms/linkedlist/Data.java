package com.algorithms.linkedlist;

/**
 * This class is a representation of the data consumed by the LinkedList It is
 * important to point out that a linkedlist can consume any type of data
 * objects, however for simplicity, this class will act as our data model
 * representaton.
 */
public class Data {
    private int id;
    private String topic;

    /**
     * No-Argument constructor Default construtor
     */
    public Data() {
        super();
    }

    /**
     * Two Argument constructor for initializing the data properties
     * 
     * @param id
     * @param topic
     */
    public Data(int id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((topic == null) ? 0 : topic.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if (id != other.id)
            return false;
        if (topic == null) {
            if (other.topic != null)
                return false;
        } else if (!topic.equals(other.topic))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nTopic: " + topic;
    }
}
