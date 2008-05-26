package org.jsmpp.util;

import org.jsmpp.PDUStringException;
import org.jsmpp.bean.OptionalParameter;

/**
 * This is utility to compose the PDU from parameter values to byte.
 * 
 * @author uudashr
 *
 */
public interface PDUComposer {

    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#composeHeader(int, int, int)
     */
    public byte[] composeHeader(int commandId, int commandStatus,
            int sequenceNumber);

    // GENERAL BIND OPERATION
    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#bind(int, int, java.lang.String,
     *      java.lang.String, java.lang.String, byte, byte, byte,
     *      java.lang.String)
     */
    public byte[] bind(int commandId, int sequenceNumber, String systemId,
            String password, String systemType, byte interfaceVersion,
            byte addrTon, byte addrNpi, String addressRange)
            throws PDUStringException;

    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#bindResp(int, int,
     *      java.lang.String)
     */
    public byte[] bindResp(int commandId, int sequenceNumber, String systemId)
            throws PDUStringException;

    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#bindResp(int, int,
     *      java.lang.String, byte)
     */
    public byte[] bindResp(int commandId, int sequenceNumber, String systemId,
            byte scInterfaceVersion) throws PDUStringException;
    
    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#unbind(int)
     */
    public byte[] unbind(int sequenceNumber);

    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#unbindResp(int, int)
     */
    public byte[] unbindResp(int commandStatus, int sequenceNumber);

    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#outbind(int, java.lang.String,
     *      java.lang.String)
     */
    public byte[] outbind(int sequenceNumber, String systemId, String password)
            throws PDUStringException;

    // ENQUIRE_LINK OPERATION
    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#enquireLink(int)
     */
    public byte[] enquireLink(int sequenceNumber);

    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#enquireLinkResp(int)
     */
    public byte[] enquireLinkResp(int sequenceNumber);

    // GENEICK_NACK OPERATION
    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#genericNack(int, int)
     */
    public byte[] genericNack(int commandStatus, int sequenceNumber);

    // SUBMIT_SM OPERATION
    /**
     * Submit short message (submit_sm).
     * 
     * @param sequenceNumber
     * @param serviceType
     * @param sourceAddrTon
     * @param sourceAddrNpi
     * @param sourceAddr
     * @param destAddrTon
     * @param destAddrNpi
     * @param destinationAddr
     * @param esmClass
     * @param protocoId
     * @param priorityFlag
     * @param scheduleDeliveryTime
     * @param validityPeriod
     * @param registeredDelivery
     * @param replaceIfPresent
     * @param dataCoding
     * @param smDefaultMsgId
     * @param shortMessage
     * @param optionalParameters
     * @return the composed byte values.
     * @throws PDUStringException
     */
    public byte[] submitSm(int sequenceNumber, String serviceType,
            byte sourceAddrTon, byte sourceAddrNpi, String sourceAddr,
            byte destAddrTon, byte destAddrNpi, String destinationAddr,
            byte esmClass, byte protocoId, byte priorityFlag,
            String scheduleDeliveryTime, String validityPeriod,
            byte registeredDelivery, byte replaceIfPresent, byte dataCoding,
            byte smDefaultMsgId, byte[] shortMessage,
            OptionalParameter... optionalParameters) throws PDUStringException;

    /**
     * Submit short message response (submit_sm_resp).
     * 
     * @param sequenceNumber
     * @param messageId
     * @return the composed byte values.
     * @throws PDUStringException
     */
    public byte[] submitSmResp(int sequenceNumber, String messageId)
            throws PDUStringException;

    // QUERY_SM OPERATION
    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#querySm(int, java.lang.String,
     *      byte, byte, java.lang.String)
     */
    public byte[] querySm(int sequenceNumber, String messageId,
            byte sourceAddrTon, byte sourceAddrNpi, String sourceAddr)
            throws PDUStringException;

    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#querySmResp(int, java.lang.String,
     *      java.lang.String, byte, byte)
     */
    public byte[] querySmResp(int sequenceNumber, String messageId,
            String finalDate, byte messageState, byte errorCode)
            throws PDUStringException;

    // DELIVER_SM OPERATION
    public byte[] deliverSm(int sequenceNumber, String serviceType,
            byte sourceAddrTon, byte sourceAddrNpi, String sourceAddr,
            byte destAddrTon, byte destAddrNpi, String destinationAddr,
            byte esmClass, byte protocolId, byte priorityFlag,
            byte registeredDelivery, byte dataCoding, byte[] shortMessage,
            OptionalParameter... optionalParameters) throws PDUStringException;

    /*
     * (non-Javadoc)
     * 
     * @see org.jsmpp.util.DefaultComposer#deliverSmResp(int)
     */
    public byte[] deliverSmResp(int sequenceNumber);

}