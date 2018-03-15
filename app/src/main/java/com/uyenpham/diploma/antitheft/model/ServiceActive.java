package com.uyenpham.diploma.antitheft.model;

public class ServiceActive {
    private String name;
    private String lock;
    private boolean isPassLock;
    private boolean isPatternLock;

    public ServiceActive(String name, String lock, boolean isPassLock, boolean isPatternLock) {
        this.name = name;
        this.lock = lock;
        this.isPassLock = isPassLock;
        this.isPatternLock = isPatternLock;
    }

    public ServiceActive() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public boolean isPassLock() {
        return isPassLock;
    }

    public void setPassLock(boolean passLock) {
        isPassLock = passLock;
    }

    public boolean isPatternLock() {
        return isPatternLock;
    }

    public void setPatternLock(boolean patternLock) {
        isPatternLock = patternLock;
    }
}
