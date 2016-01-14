/*
 * Copyright (C) 2013 Cable Television Laboratories, Inc.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL APPLE INC. OR ITS CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

#ifndef TextSinkGStreamer_h
#define TextSinkGStreamer_h

#if ENABLE(VIDEO) && USE(GSTREAMER) && ENABLE(VIDEO_TRACK)

#include <glib-object.h>
#include <gst/app/gstappsink.h>
#include <gst/gst.h>

#define WEBKIT_TYPE_TEXT_SINK webkit_text_sink_get_type()

#define WEBKIT_TEXT_SINK(obj) (G_TYPE_CHECK_INSTANCE_CAST((obj), WEBKIT_TYPE_TEXT_SINK, WebKitTextSink))
#define WEBKIT_TEXT_SINK_CLASS(klass) (G_TYPE_CHECK_CLASS_CAST((klass), WEBKIT_TYPE_TEXT_SINK, WebKitTextSinkClass))
#define WEBKIT_IS_TEXT_SINK(obj) (G_TYPE_CHECK_INSTANCE_TYPE((obj), WEBKIT_TYPE_TEXT_SINK))
#define WEBKIT_IS_TEXT_SINK_CLASS(klass) (G_TYPE_CHECK_CLASS_TYPE((klass), WEBKIT_TYPE_TEXT_SINK))
#define WEBKIT_TEXT_SINK_GET_CLASS(obj) (G_TYPE_INSTANCE_GET_CLASS((obj), WEBKIT_TYPE_TEXT_SINK, WebKitTextSinkClass))

typedef struct _WebKitTextSink WebKitTextSink;
typedef struct _WebKitTextSinkClass WebKitTextSinkClass;

struct _WebKitTextSink {
    GstAppSink parent;
};

struct _WebKitTextSinkClass {
    GstAppSinkClass parentClass;

    // Future padding
    void (* _webkit_reserved1)(void);
    void (* _webkit_reserved2)(void);
    void (* _webkit_reserved3)(void);
    void (* _webkit_reserved4)(void);
    void (* _webkit_reserved5)(void);
    void (* _webkit_reserved6)(void);
};

GstElement* webkitTextSinkNew();

#endif // ENABLE(VIDEO) && USE(GSTREAMER) && ENABLE(VIDEO_TRACK)
#endif
