package com.uyenpham.diploma.antitheft.model;

public class ServiceLock {
    private String lock;
    private boolean isPassLock;
    private boolean isPatternLock;

    public ServiceLock( String lock, boolean isPassLock, boolean isPatternLock) {
        this.lock = lock;
        this.isPassLock = isPassLock;
        this.isPatternLock = isPatternLock;
    }

    public ServiceLock() {
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
