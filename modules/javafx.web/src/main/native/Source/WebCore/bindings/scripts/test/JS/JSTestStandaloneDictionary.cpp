/*
    This file is part of the WebKit open source project.
    This file has been generated by generate-bindings.pl. DO NOT MODIFY!

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Library General Public
    License as published by the Free Software Foundation; either
    version 2 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Library General Public License for more details.

    You should have received a copy of the GNU Library General Public License
    along with this library; see the file COPYING.LIB.  If not, write to
    the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
    Boston, MA 02110-1301, USA.
*/

#include "config.h"

#if ENABLE(Condition1)

#include "JSTestStandaloneDictionary.h"

#include "JSDOMConvertBoolean.h"
#include "JSDOMConvertStrings.h"
#include <runtime/JSCInlines.h>
#include <runtime/JSString.h>
#include <wtf/NeverDestroyed.h>

using namespace JSC;

namespace WebCore {

#if ENABLE(Condition1)

template<> DictionaryImplName convertDictionary<DictionaryImplName>(ExecState& state, JSValue value)
{
    VM& vm = state.vm();
    auto throwScope = DECLARE_THROW_SCOPE(vm);
    bool isNullOrUndefined = value.isUndefinedOrNull();
    auto* object = isNullOrUndefined ? nullptr : value.getObject();
    if (UNLIKELY(!isNullOrUndefined && !object)) {
        throwTypeError(&state, throwScope);
        return { };
    }
    DictionaryImplName result;
    JSValue boolMemberValue = isNullOrUndefined ? jsUndefined() : object->get(&state, Identifier::fromString(&state, "boolMember"));
    if (!boolMemberValue.isUndefined()) {
        result.boolMember = convert<IDLBoolean>(state, boolMemberValue);
        RETURN_IF_EXCEPTION(throwScope, { });
    }
    JSValue enumMemberValue = isNullOrUndefined ? jsUndefined() : object->get(&state, Identifier::fromString(&state, "enumMember"));
    if (!enumMemberValue.isUndefined()) {
        result.enumMember = convert<IDLEnumeration<TestStandaloneDictionary::EnumInStandaloneDictionaryFile>>(state, enumMemberValue);
        RETURN_IF_EXCEPTION(throwScope, { });
    }
    JSValue stringMemberValue = isNullOrUndefined ? jsUndefined() : object->get(&state, Identifier::fromString(&state, "stringMember"));
    if (!stringMemberValue.isUndefined()) {
        result.stringMember = convert<IDLDOMString>(state, stringMemberValue);
        RETURN_IF_EXCEPTION(throwScope, { });
    }
    return result;
}

#endif

template<> JSString* convertEnumerationToJS(ExecState& state, TestStandaloneDictionary::EnumInStandaloneDictionaryFile enumerationValue)
{
    static const NeverDestroyed<String> values[] = {
        MAKE_STATIC_STRING_IMPL("enumValue1"),
        MAKE_STATIC_STRING_IMPL("enumValue2"),
    };
    static_assert(static_cast<size_t>(TestStandaloneDictionary::EnumInStandaloneDictionaryFile::EnumValue1) == 0, "TestStandaloneDictionary::EnumInStandaloneDictionaryFile::EnumValue1 is not 0 as expected");
    static_assert(static_cast<size_t>(TestStandaloneDictionary::EnumInStandaloneDictionaryFile::EnumValue2) == 1, "TestStandaloneDictionary::EnumInStandaloneDictionaryFile::EnumValue2 is not 1 as expected");
    ASSERT(static_cast<size_t>(enumerationValue) < WTF_ARRAY_LENGTH(values));
    return jsStringWithCache(&state, values[static_cast<size_t>(enumerationValue)]);
}

template<> std::optional<TestStandaloneDictionary::EnumInStandaloneDictionaryFile> parseEnumeration<TestStandaloneDictionary::EnumInStandaloneDictionaryFile>(ExecState& state, JSValue value)
{
    auto stringValue = value.toWTFString(&state);
    if (stringValue == "enumValue1")
        return TestStandaloneDictionary::EnumInStandaloneDictionaryFile::EnumValue1;
    if (stringValue == "enumValue2")
        return TestStandaloneDictionary::EnumInStandaloneDictionaryFile::EnumValue2;
    return std::nullopt;
}

template<> const char* expectedEnumerationValues<TestStandaloneDictionary::EnumInStandaloneDictionaryFile>()
{
    return "\"enumValue1\", \"enumValue2\"";
}

} // namespace WebCore

#endif // ENABLE(Condition1)
