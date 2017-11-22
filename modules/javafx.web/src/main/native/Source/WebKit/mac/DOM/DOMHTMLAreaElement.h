/*
 * Copyright (C) 2004-2016 Apple Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY APPLE INC. ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL APPLE INC. OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

#import <WebKitLegacy/DOMHTMLElement.h>

@class NSString;
@class NSURL;

WEBKIT_CLASS_AVAILABLE_MAC(10_4)
@interface DOMHTMLAreaElement : DOMHTMLElement
@property (copy) NSString *alt;
@property (copy) NSString *coords;
@property BOOL noHref;
@property (copy) NSString *shape;
@property (copy) NSString *target;
@property (copy) NSString *accessKey WEBKIT_DEPRECATED_MAC(10_4, 10_8);
@property (readonly, copy) NSURL *absoluteLinkURL WEBKIT_AVAILABLE_MAC(10_5);
@property (copy) NSString *href;
@property (readonly, copy) NSString *protocol WEBKIT_AVAILABLE_MAC(10_5);
@property (readonly, copy) NSString *host WEBKIT_AVAILABLE_MAC(10_5);
@property (readonly, copy) NSString *hostname WEBKIT_AVAILABLE_MAC(10_5);
@property (readonly, copy) NSString *port WEBKIT_AVAILABLE_MAC(10_5);
@property (readonly, copy) NSString *pathname WEBKIT_AVAILABLE_MAC(10_5);
@property (readonly, copy) NSString *search WEBKIT_AVAILABLE_MAC(10_5);
@property (readonly, copy) NSString *hashName WEBKIT_AVAILABLE_MAC(10_5);
@end
