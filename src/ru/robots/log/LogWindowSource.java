package ru.robots.log;

import java.util.*;


public class LogWindowSource {
    private int m_iQueueLength;
    
//    private ArrayList<LogEntry> m_messages; // сделать очередь вместо листа
    private Deque<LogEntry> m_messages;
//    private final ArrayList<LogChangeListener> m_listeners;
    private final Deque<LogChangeListener> m_listeners;
    private volatile LogChangeListener[] m_activeListeners;
    
    public LogWindowSource(int iQueueLength) {
        m_iQueueLength = iQueueLength;
//        m_messages = new ArrayList<LogEntry>(iQueueLength);
//        m_listeners = new ArrayList<LogChangeListener>();
        m_messages = new ArrayDeque<>();
        m_listeners = new ArrayDeque<>();
    }
    
    public void registerListener(LogChangeListener listener) {
        synchronized(m_listeners) {
            m_listeners.add(listener);
//            m_activeListeners = null;
        }
    }
    
    public void unregisterListener(LogChangeListener listener) {
        synchronized(m_listeners) {
            m_listeners.remove(listener);
//            m_activeListeners = null;
        }
    }
    
    public void append(LogLevel logLevel, String strMessage) {
        LogEntry entry = new LogEntry(logLevel, strMessage);
        m_messages.add(entry);
        updateMessagesQueue(m_iQueueLength);
        LogChangeListener [] activeListeners = m_activeListeners;
        if (activeListeners == null) {
            synchronized (m_listeners) {
                if (m_activeListeners == null) {
                    activeListeners = m_listeners.toArray(new LogChangeListener [0]);
                    m_activeListeners = activeListeners;
                }
            }
        }
        for (LogChangeListener listener : activeListeners) {
            listener.onLogChanged();
        }
    }
    
    public int size() {
        return m_messages.size();
    }

//    public Iterable<LogEntry> range(int startFrom, int count) {
//        if (startFrom < 0 || startFrom >= m_messages.size()) {
//            return Collections.emptyList();
//        }
//        int indexTo = Math.min(startFrom + count, m_messages.size());
//        return m_messages.subList(startFrom, indexTo);
//    }

    public Iterable<LogEntry> all() {
        return m_messages;
    }

    public void updateMessagesQueue(int m_size) {
        if (size() > m_size) {
            m_messages.remove(0);
        }
    }
}
