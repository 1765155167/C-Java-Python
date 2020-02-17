package com.hqf.webview;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentHandler extends DefaultHandler {
    private String nodeName;
    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;
    private StringBuilder sb;
    SAXCallBack callBack;
    private static final String TAG = "ContentHandler";

    public ContentHandler(SAXCallBack callBack) {
        this.callBack = callBack;
    }

    //开始xml解析时调用
    @Override
    public void startDocument() throws SAXException {
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }
    //开始解析某个节点时调用
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeName = localName;//记录当前节点名
    }
    //获取节点中内容时调用
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //根据节点吗判断将内容添加到哪一个StringBuilder中
        if ("id".equals(nodeName)) {
            id.append(ch, start, length);
        } else if ("name".equals(nodeName)) {
            name.append(ch, start, length);
        } else if ("version".equals(nodeName)) {
            version.append(ch, start, length);
        }
    }
    //完成解析某个节点时调用
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("app".equals(nodeName)) {
            //trim()去除换行符
            Log.d(TAG, "id is " + id.toString().trim());
            Log.d(TAG, "name is " + name.toString().trim());
            Log.d(TAG, "version is " + version.toString().trim());
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }
    //完成整个xml解析时调用
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        this.callBack.execute(sb.toString());
    }
}
