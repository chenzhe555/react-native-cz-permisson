
Pod::Spec.new do |s|
  s.name         = "RNCzPermission"
  s.version      = "1.0.0"
  s.summary      = "RNCzPermission"
  s.description  = "RN App权限校验"
  s.homepage     = "https://github.com/chenzhe555/react-native-cz-permisson"
  s.license      = { :type => "MIT", :file => "LICENSE" }
  s.author       = { "author" => "376811578@qq.com" }
  s.platform     = :ios, "9.0"
  s.source       = { :git => "https://github.com/chenzhe555/react-native-cz-permisson.git", :tag => s.version }
  s.source_files = "*.{h,m}"
  s.requires_arc = true
  s.dependency "React"
  #s.dependency "others"

end

  